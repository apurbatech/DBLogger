/*
 * DBConnectionManager.java
 *
 * Created on March 20, 2010, 10:42 AM
 *
 * Manage the database connection from here.
 * Just extends the class and use the dbhandler.
 */

package com.xbrl.server.manager;

import com.xbrl.server.dal.DBConnection;
import com.xbrl.server.dal.DBHandler;

/**
 *
 * @author Yousuf Zaman
 */
public class DBConnectionManager
{
    //public DBConnection dbconn = new DBConnection();
    //public DBHandler dbhandler = dbconn.newConnection();
    
    public DBHandler dbhandler    = DBConnection.newConnection();
    public DBConnectionManager()
    {
         try
         {
           if(dbhandler.getConnection() == null || dbhandler.getConnection().isClosed())
           {
               dbhandler = DBConnection.newConnection();
           }
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
