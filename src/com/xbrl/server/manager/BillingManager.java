package com.xbrl.server.manager;

import com.xbrl.log.LogWriter;
import com.xbrl.server.bean.BillingInfo;
import com.xbrl.server.common.Utilities;
import com.xbrl.server.dal.DefaultProperties;
import java.sql.ResultSet;

/**
 *
 * @author Nazmul Hasan
 */
public class BillingManager extends DBConnectionManager{
    LogWriter logger = new LogWriter();
    public BillingManager()
    {
        logger.className("BillingManager");
        logger.disableLog();
        logger.enableLogInFile();
        logger.enableErrorLogInFile();
    }
    
    /*
     * This method will add billing info
     * @author Nazmul Hasan on 3rd April 2015
     */
    public boolean addBillingInfo(BillingInfo billingInfo)
    {
        logger.print("Adding biling for for the userid:"+billingInfo.getUserId());
        boolean status = true;
        float price = this.getBillingPrice(billingInfo);
        try
        {
            String sql = "";
            sql += "INSERT INTO "+DefaultProperties.BILLING_INFO_TBL+" ";
            sql += " (user_id, price, billing_type_id) VALUES ";
            sql += " ('"+billingInfo.getUserId()+"','"+ price +"','"+ billingInfo.getBillingTypeId() +"')";
            int lastInsertedId  = dbhandler.insert(sql, DefaultProperties.SEQ_BILLING_INFO_TBL);
            if(lastInsertedId > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            logger.error("addBillingInfo(BillingInfo billingInfo) Storing billing info for the userid: "+billingInfo.getUserId());
            logger.error("EXCEPTION: "+e.toString());
            return false;
        }
    }
    
    public float getBillingPrice(BillingInfo billingInfo)
    {
        logger.print("Calaulating billing price");
        float price = 0;        
        //right now we have generated the price from the billing type info table. Consider bill assigned by each user later
        String sql = "SELECT price ";
        sql += "FROM "+DefaultProperties.BILLING_TYPE_INFO_TBL+" WHERE billing_type_id = "+billingInfo.getBillingTypeId();
        try
        {
            ResultSet rs    = dbhandler.select(sql);
            if(rs.next())
            {
                price = rs.getFloat("price");
            }
            dbhandler.closeResult(rs);
        }
        catch(Exception e)
        {
            logger.error("getBillingPrice(BillingInfo billingInfo)...Error while selecting price from billing type info table");
            logger.error("EXCEPTION: "+e.toString());
        }        
        return price;
    }
}