package com.xbrl.server.manager;

import com.xbrl.log.LogWriter;
import com.xbrl.server.bean.UserInfo;
import com.xbrl.server.dal.DefaultProperties;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nazmul hasan
 */
public class AuthManager extends DBConnectionManager{
    private String ipAddress = "";
    LogWriter logger = new LogWriter();
    private String message = "";
    /*
     * Constructor
     * @author nazmul on 24th February 2015
     */
    public AuthManager()
    {
        logger.className("AuthManager");
        logger.disableLog();
        logger.enableLogInFile();
        logger.enableErrorLogInFile();
    }
    /*
     * setter method for message field
     * @author nazmul hasan on 26th February 2015
     * 
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /*
     * getter method for message field
     * @author nazmul hasan on 26th February 2015
     * 
     */
    public String getMessage() {
        return message;
    }
    
    /*
     * This method will set ipaddress
     * @param $ipAddress, ipaddress
     * @author Nazmul on 25th February 2015
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    /*
     * This method will return ipaddress
     * @author Nazmul on 25th February 2015
     */
    public String getIpAddress() {
        return ipAddress;
    }
    
    /*
     * This method will check user
     * @param userName, user name
     * @param userPass, user password
     * @author Nazmul on 25th February 2015
     */
    public UserInfo checkUser(String userName, String userPass)
    {
        //<editor-fold defaultstate="collapsed" desc="Chech authentication by username and password">
        logger.print("login attempt [checkUser]: userName:"+userName);
        if(userName.length() == 0)
        {
            setMessage("User name is required");
        }
        else if(userPass.length() == 0)
        {
            setMessage("Password is required");
        }
        int userTypeId = 0;
        int userId = 0;
        String sql  = "SELECT exclude_instance_report, exclude_detail_note, exclude_hats, user_id, user_name, user_pass, user_email, create_date, last_update, html, xbrl, user_type_id, active, ";
        sql         += "default_template_id, default_paragraph_id, default_graphic_id, default_list_id, first_name, last_name, cell_no, fax_no, website, active  , pagination, page_range ";
        sql         += "FROM "+DefaultProperties.USER_INFO_TBL+" WHERE user_name ='"+userName+"' AND user_pass='"+userPass+"'";
        UserInfo uInfo  = null;
        boolean loginStat = false;
        try
        {
            ResultSet rs    = dbhandler.select(sql);
            if(rs.next())
            {
                if(!rs.getBoolean("active")){
                    setMessage("Your account is inactive. Please contact with system administrator.");
                    return uInfo;
                }
                loginStat = true;
                uInfo = new UserInfo();
                userId = rs.getInt("user_id");
                uInfo.setUserId(                rs.getInt("user_id"));
                uInfo.setUserName(              rs.getString("user_name"));
                uInfo.setUserPassword(          rs.getString("user_pass"));
                uInfo.setUserEmail(             rs.getString("user_email"));
                uInfo.setCreateDate(            rs.getString("create_date"));
                uInfo.setLastUpdate(            rs.getString("last_update"));
                uInfo.setHtml(                  rs.getBoolean("html"));
                uInfo.setXbrl(                  rs.getBoolean("xbrl"));
                uInfo.setDefaultTemplateID(     rs.getInt("default_template_id"));
                uInfo.setDefaultParagraphID(    rs.getInt("default_paragraph_id"));
                uInfo.setDefaultGraphicID(      rs.getInt("default_graphic_id"));
                uInfo.setDefaultListID(         rs.getInt("default_list_id"));                
                uInfo.setFirstName(             rs.getString("first_name"));
                uInfo.setLastName(              rs.getString("last_name"));
                uInfo.setCellNo(                rs.getString("cell_no"));
                uInfo.setFaxNo(                 rs.getString("fax_no"));
                uInfo.setWebsite(               rs.getString("website"));
                uInfo.setActive(                rs.getBoolean("active"));
                uInfo.setPaginationEnabled(rs.getBoolean("pagination"));
                uInfo.setPageRange(rs.getInt("page_range"));
                uInfo.setSubscriberId(          this.getSubscriberId(userId));
                uInfo.setSubscriberName(        this.getSubscriberName(uInfo.getSubscriberId()));
                userTypeId                      = rs.getInt("user_type_id");
                uInfo.setExcludeDetailNote(rs.getBoolean("exclude_detail_note"));
                uInfo.setExcludeInstanceReport(rs.getBoolean("exclude_instance_report"));
                uInfo.setExcludeHATs(rs.getBoolean("exclude_hats"));
            }
            dbhandler.closeResult(rs);
        }
        catch(Exception e)
        {
            logger.error("checkUser(userName,userPass) Accessing  USER_INFO_TBL userName: "+userName);
            logger.error("EXCEPTION: "+e.toString());
        }
        logger.print("Ip Address is : "+ipAddress);
        boolean ipAddressExists = false;
        //checking whether this ip address exists or not
        try
        {
            sql  = "SELECT ip_address ";
            sql         += "FROM "+DefaultProperties.IP_INFO_TBL+" WHERE ip_address ='"+ipAddress+"'";
            ResultSet rs    = dbhandler.select(sql);
            if(rs.next()){
                ipAddressExists = true;
            }   
            dbhandler.closeResult(rs);
        }
        catch(Exception e)
        {
            logger.error("checkUser(userName,userPass) Accessing  IP_INFO_TBL userName: "+userName);
            logger.error("EXCEPTION: "+e.toString());
        }
        //accessing for the first time from this ip
        if(!ipAddressExists){
            int wrongAttempt = 0;
            if(uInfo == null){
                wrongAttempt = 1;
                try {
                    long current_time_sec = System.currentTimeMillis() / 1000;
                    sql = "";
                    sql += "INSERT INTO " + DefaultProperties.IP_INFO_TBL + " ";
                    sql += " (ip_address, wrong_attempt, last_access_time) VALUES ";
                    sql += " ('" + ipAddress + "','" + wrongAttempt + "','" + current_time_sec + "')";
                    int lastInsertedId = dbhandler.insert(sql, DefaultProperties.SEQ_IP_INFO_TBL);
                    setMessage("Incorrect user name or password. Please try again.");
                    return null;
                } catch (Exception e) {
                    logger.error("checkUser(userName,userPass) Storing data in IP_INFO_TBL userName: "+userName);
                    logger.error("EXCEPTION: "+e.toString());
                }
            }
        }
        else{
            int wrongAttempt = 0;
            long lastAccessTime = 0;
            //retrieving wrong attempt and last access time for this ip
            try {
                sql = "SELECT wrong_attempt, last_access_time ";
                sql += "FROM " + DefaultProperties.IP_INFO_TBL + " WHERE ip_address ='" + ipAddress + "'";
                ResultSet rs = dbhandler.select(sql);
                if (rs.next()) {
                    wrongAttempt = rs.getInt("wrong_attempt");
                    lastAccessTime = rs.getLong("last_access_time");
                }
                dbhandler.closeResult(rs);
            }
            catch (Exception e) {
                logger.error("checkUser(userName,userPass) Accessing IP_INFO_TBL using ipaddress for userName: "+userName);
                logger.error("EXCEPTION: "+e.toString());                
            }
            long currentTimeInSecond = System.currentTimeMillis() / 1000;
            long accessTimeDifference = currentTimeInSecond - lastAccessTime;
            if(uInfo == null){                
                if(accessTimeDifference >= 86400){
                    wrongAttempt = 1;
                }
                else{
                    wrongAttempt++;
                }
                try {
                    long current_time_sec = System.currentTimeMillis() / 1000;
                    sql = "";
                    sql = "UPDATE " + DefaultProperties.IP_INFO_TBL + " SET ";
                    sql += " wrong_attempt = '" + wrongAttempt + "', ";
                    sql += " last_access_time ='" + current_time_sec + "' ";
                    sql += " WHERE ip_address ='" + ipAddress + "' ";

                    int insertStat = dbhandler.update(sql);                    
                }
                catch (Exception ex) {
                    logger.error("checkUser(userName,userPass) Updating IP_INFO_TBL userName: "+userName);
                    logger.error("EXCEPTION: "+ex.toString());
                }
                setMessage("Incorrect user name or password. Please try again.");
                return null;
            }
            else{
                if(wrongAttempt >= 5){
                    if(accessTimeDifference < 86400){
                        setMessage("Your account is locked due to wrong attempt. Please contact with system administrator.");
                        return null;
                    }
                }
            }
        }
        if(!loginStat){
            setMessage("Incorrect user name or password. Please try again.");
            return uInfo;
        }        
        if(userTypeId > 0){
            int subscriberId = this.getSubscriberId(userId);
            try {
                String sql2 = "SELECT user_type_name ";
                sql2 += "FROM " + DefaultProperties.USER_TYPE_INFO_TBL + " WHERE user_type_id ='" + userTypeId + "'";
                ResultSet rs = dbhandler.select(sql2);
                if (rs.next()) {
                    uInfo.setUserType(rs.getString(1));
                }
                dbhandler.closeResult(rs);
            }
            catch (Exception e) 
            {
                logger.error("checkUser(userName,userPass) Accessing USER_TYPE_INFO_TBL userName: "+userName);
                logger.error("EXCEPTION: "+e.toString());
            }
            //user needs cik, ccc, pass from subscriber other than super admin
            if(userTypeId >= 2){
                try {
                    String sql2 = "SELECT total_user, cik, ccc, pass, subscription_date_from, subscription_date_to ";
                    sql2 += "FROM " + DefaultProperties.SUBSCRIBER_INFO_TBL + " WHERE user_id ='" + subscriberId + "'";
                    ResultSet rs = dbhandler.select(sql2);
                    if (rs.next()) {
                        uInfo.setTotalUser(rs.getInt("total_user"));
                        uInfo.setCik(rs.getString("cik"));
                        uInfo.setCcc(rs.getString("ccc"));
                        uInfo.setPassword(rs.getString("pass"));
                        uInfo.setSubscriptionDateFrom(rs.getString("subscription_date_from"));
                        uInfo.setSubscriptionDateTo(rs.getString("subscription_date_to"));                        
                    }
                    //checking subscription period for subscriber, if it is over null is returned
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date subscriptionToDate = dateFormat.parse(uInfo.getSubscriptionDateTo());
                    Date today = new Date((new Date()).getTime()-86400000);                    
                    if(today.compareTo(subscriptionToDate)>0){
                        logger.print("UserManager->checkUser()....Subscription period is over, returning null.");
                        setMessage("Your subscription period is over. Please contact with system administrator.");
                        return null;
                    }                    
                    dbhandler.closeResult(rs);
                }
                catch (Exception e) {
                    logger.error("checkUser(userName,userPass) Accessing SUBSCRIBER_INFO_TBL userName: "+userName);
                    logger.error("EXCEPTION: "+e.toString());
                }
            }
            //checking subscriber active status of this member
            if(userTypeId == 3){                
                try {
                    //checking active status
                    String sql1 = "SELECT active  ";
                    sql1 += "FROM " + DefaultProperties.USER_INFO_TBL + " WHERE user_id =" + subscriberId;
                    ResultSet rs1 = dbhandler.select(sql1);
                    if (rs1.next()) {
                        if (!rs1.getBoolean("active")) {
                            logger.print("UserManager->checkUser()....subscriber of this member is inactive, returning null.");
                            setMessage("Your account is inactive. Please contact with system administrator.");
                            return null;
                        }
                    }
                    dbhandler.closeResult(rs1);                    
                }
                catch (Exception e) {
                    logger.error("checkUser(userName,userPass) > checking subscriber active status and subscription period for a member");
                    logger.error("EXCEPTION: " + e.toString());
                }
            }
        }
        //clearing ip_info table
        try{
            String sql2 = "";
            sql2 += "update "+DefaultProperties.IP_INFO_TBL+" set wrong_attempt = 0 where ip_address = '"+ipAddress+"'";
            int insertStat = dbhandler.update(sql2);
        }
        catch(Exception ex){
            logger.error("checkUser(userName,userPass)..Error while unlocking locked ip address.");
            logger.error("EXCEPTION: "+ex.toString());
        }        
        return uInfo;
        //</editor-fold>
    }
    /*
     * This method will return subscriber id of a user
     * @param userId, user id
     * @Author Nazmul on 25th February 2015
     */
    public int getSubscriberId(int userId)
    {
        try
        {
            String sql  = "SELECT subscriber_id ";
            sql         += "FROM "+DefaultProperties.SUBSCRIBER_USER_INFO_TBL+" WHERE subscriber_user_id ='"+userId+"'";
            ResultSet rs    = dbhandler.select(sql);
            if(rs.next())
                userId = rs.getInt(1);
            dbhandler.closeResult(rs);
        }
        catch(Exception e)
        {
            logger.error("getSubscriberId(userId) Accessing SUBSCRIBER_USER_INFO_TBL userId: "+userId);
            logger.error("EXCEPTION: "+e.toString());
        }
        return userId;
    }
    
    /*
     * This method will return name of a subscriber
     * @param subscriberId, subscriber id
     * @author Nazmul on 25th February 2015
     */
    public String getSubscriberName(int subscriberId)
    {
        String subscriberName = "";
        try
        {
            String sql  = "SELECT first_name, last_name ";
            sql         += "FROM "+DefaultProperties.USER_INFO_TBL+" WHERE user_id ='"+subscriberId+"'";
            ResultSet rs    = dbhandler.select(sql);
            if(rs.next()){
                if(rs.getString("first_name") != null)
                    subscriberName += rs.getString("first_name")+" ";
                if(rs.getString("last_name") != null)
                    subscriberName += rs.getString("last_name");
            }
            dbhandler.closeResult(rs);
        }
        catch(Exception e)
        {
            logger.error("getSubscriberId(userId) Accessing USER_INFO_TBL subscriberId: "+subscriberId);
            logger.error("EXCEPTION: "+e.toString());
        }
        return subscriberName;
    }
}
