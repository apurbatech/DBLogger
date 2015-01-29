/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbrl.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

/**
 *
 * @author Alamgir
 */
public class Utilities {
    LogWriter logger = new LogWriter();
    public Utilities()
    {
        logger.className("XBRLUtils");
        logger.enableLogInFile();
        logger.enableErrorLogInFile();
    }
    public String getPropertiesByKey(String key)
    {
         //<editor-fold defaultstate="collapsed" desc="Return Property files Value by Key.">
        String keyValue = "";
        try
        {
            Properties property = new Properties();
            InputStream stream = Utilities.class.getResourceAsStream("general.properties");
            property.load(stream);
            keyValue        = property.getProperty(key);
        }
        catch(IOException ex)
        {
            logger.error("getPropertiesByKey key"+key);
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            logger.error("getPropertiesByKey key"+key);
            ex.printStackTrace();
        }
        return keyValue;
        //</editor-fold>
    }
    /**
     * Return System current date time by format
     * @param format
     * @return
     */
    public String getSystemCurrentDate(String format)
    {
        //<editor-fold defaultstate="collapsed" desc="Return Current Date by date format">
        java.text.DateFormat dateFormat = new java.text.SimpleDateFormat(format);
        java.util.Date date = new java.util.Date();
        String strDate = dateFormat.format(date);
        return strDate;
        //</editor-fold>
    }
    
    /**
     * Write Data to Given File.
     * @param fileUrl
     * @param fileData
     * @return int status
     */
    public int writeFileContents(String fileUrl, String fileData)
    {
        //<editor-fold defaultstate="collapsed" desc="Write given data to given fileName and location.">
        BufferedWriter out=null;
        try
        {
            //String fileDir = "files";
            //boolean success = (new File(fileDir)).mkdir();

            File outFile = new File(fileUrl);
            outFile.delete();
            outFile = new File(fileUrl);

            //out = new BufferedWriter(new FileWriter(outFile, true ));
            //logger.print("writeFileContents fileUrl: utf8");
            //out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF8"));
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile, true),"UTF8"));
            out.write(fileData);
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("writeFileContents fileUrl:"+fileUrl);
            return 0;
        }
        return 1;
        //</editor-fold>
    }
    
        public int writeFileContents(String fileUrl, String fileData, boolean append)
    {
        //<editor-fold defaultstate="collapsed" desc="Write given data to given fileName and location.">
        BufferedWriter out=null;
        try
        {
            //String fileDir = "files";
            //boolean success = (new File(fileDir)).mkdir();

            File outFile = new File(fileUrl);
            outFile.getParentFile().mkdirs();
            //out = new BufferedWriter(new FileWriter(outFile, append ));
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile, append),"UTF8"));
            out.write(fileData);
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("writeFileContents fileUrl:"+fileUrl);
            return 0;
        }
        return 1;
        //</editor-fold>
    }
}
