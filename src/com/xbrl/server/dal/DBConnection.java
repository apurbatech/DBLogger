/*
 * DBManager.java
 *
 * Created on January 27, 2010, 4:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xbrl.server.dal;

import com.xbrl.log.LogWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Yousuf Zaman
 */
public class DBConnection
{
    public static DBHandler dbhandler=null;

    /**
     * Creates a new instance of DBConnection
     */
    public DBConnection() 
    {
    }

    /*****************************************************
     * Return a DBHandler Object for Database Releted Operation
     * @return
     * @return: DBHandler Object
     ****************************************************/
    public static DBHandler newConnection()
    {
        //<editor-fold defaultstate="collapsed" desc="Return a New Connection">
        try
        {
            if(dbhandler==null || dbhandler.getConnection() ==null || dbhandler.getConnection().isClosed())
            //if(dbhandler==null)
            {
                //LogWriter.writeLog("========NEW connection created=========.", "sql");
                DBConfiguration conf   = new DBConfiguration();
                dbhandler=new DBHandler();
                Class.forName(conf.JDBC_DRIVER);
                dbhandler.setConnection(DriverManager.getConnection(conf.DATABASE_URL, conf.USERNAME, conf.PASSWORD));
            }
            else
            {
                //LogWriter.writeLog("===____===OLD connection used.","sql");
                return dbhandler;
            }
                
        }
        catch(IOException ex)
        {
            LogWriter.writeLog("===____===IO CONNECTION ERROR ."+ex.getLocalizedMessage(),"sql");
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            LogWriter.writeLog("===____===CONNECTION ERROR ."+ex.getLocalizedMessage(),"sql");
            ex.printStackTrace();
        }
        return dbhandler;
        //</editor-fold>
    }
    
    /**
     *
     * @param jdbcDriver
     * @param dbUrl
     * @param dbUser
     * @param dbPass
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static DBHandler newConnection(String jdbcDriver, String dbUrl, String dbUser, String dbPass)
    throws SQLException, Exception
    {
        dbhandler=new DBHandler();
        Class.forName(jdbcDriver);
        dbhandler.setConnection(DriverManager.getConnection(dbUrl, dbUser, dbPass));
        return dbhandler;
    }

    /*****************************************************
     * Close The Connection
     * @return: void
     ****************************************************/
    public static void closeConnection()
    {
        //<editor-fold defaultstate="collapsed" desc="Cloase Existing Connection.">
        try
        {
            if(dbhandler!=null)
            {
                dbhandler.closeConnection();
                dbhandler=null;
            }
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
        //</editor-fold>
    }
}
