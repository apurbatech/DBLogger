package com.xbrl.server.manager;

import com.xbrl.server.bean.UserInfo;
import com.xbrl.server.dal.DefaultProperties;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nazmul
 */
public class AuthManager extends DBConnectionManager{
    private String ipAddress = "";
    /*
     * Constructor
     * @author nazmul on 24th February 2015
     */
    public AuthManager()
    {
    
    }
    public UserInfo checkUser(String userName, String userPass)
    {
        //<editor-fold defaultstate="collapsed" desc="Chech authentication by username and password">
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
                if(!rs.getBoolean("active"))
                    return uInfo;
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
            
        }

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
            e.printStackTrace();
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
                    return null;
                } catch (Exception e) {
                    
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
                    
                }
                return null;
            }
            else{
                if(wrongAttempt >= 5){
                    if(accessTimeDifference < 86400){
                        return null;
                    }
                }
            }
        }
        if(!loginStat)
            return uInfo;        
        //clearing ip_info table
        try{
            String sql2 = "";
            sql2 += "update "+DefaultProperties.IP_INFO_TBL+" set wrong_attempt = 0 where ip_address = '"+ipAddress+"'";
            int insertStat = dbhandler.update(sql2);
        }
        catch(Exception ex){
            
        }        
        return uInfo;
        //</editor-fold>
    }
    
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
            
        }
        return userId;

    }
    
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
            
        }
        return subscriberName;

    }
}
