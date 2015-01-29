/*
 * DBConfiguration.java
 *
 * Created on January 27, 2010, 03:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xbrl.server.dal;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Yousuf Zaman
 */
public class DBConfiguration
{
    String PASSWORD;
    String USERNAME;
    String JDBC_DRIVER;
    String DATABASE_URL;

     /*****************************************************
     * Constructor for DBConfiguration
      * @throws IOException
      * @return: void
     ****************************************************/
    public DBConfiguration() throws IOException
    {
        //<editor-fold defaultstate="collapsed" desc="DBConfiguration Constructor.">
        Properties property = new Properties();
        InputStream stream = DBConfiguration.class.getResourceAsStream("dbConnection.properties");
        property.load(stream);

        PASSWORD        = property.getProperty("PASSWORD");
        USERNAME        = property.getProperty("USERNAME");
        JDBC_DRIVER     = property.getProperty("JDBC_DRIVER");
        DATABASE_URL    = property.getProperty("DATABASE_URL");
        //</editor-fold>
    }

    /**
     * get user name
     * @return string user name
     */
    public String getUserName()
    {
        return this.USERNAME;
    }

    /**
     * 
     * @return
     */
    public String getDatabaseURL()
    {
        return this.DATABASE_URL;
    }
}