/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xbrl.log;

import com.xbrl.server.common.Utilities;

/**
 *
 * @author yzaman
 */
public class LogWriter
{
    private boolean isLogEnable             = true;
    private boolean isLogEnableInFile       = false;
    private boolean isErrorLogEnableInFile  = false;
    private String className = "";
    public LogWriter()
    {
        this.isLogEnable = true;
    }
    public LogWriter(String clsName)
    {
        this.isLogEnable = true;
        this.className = "["+clsName+"]";
    }

    public LogWriter(boolean flag)
    {
        this.isLogEnable = flag;
    }

    public void className(String clsName)
    {
        this.className = "["+clsName+"]";
    }

    public void print(String msg)
    {
        if(isLogEnableInFile)
        {
            this.write(this.className+" : "+msg,"debug");
        }
        if(isLogEnable)
            System.out.println(msg);
    }

    public void print()
    {
        System.out.println();
    }
    
    public void print(boolean msg)
    {
        if(isLogEnableInFile)
        {
            this.write(this.className+" : "+msg,"debug");
        }
        if(isLogEnable)
            System.out.println(msg);
    }
    public void print(int msg)
    {
        if(isLogEnableInFile)
        {
            this.write(this.className+" : "+msg,"debug");
        }
        if(isLogEnable)
            System.out.println(msg);
    }
    
    public void print(long msg)
    {
        if(isLogEnableInFile)
        {
            this.write(this.className+" : "+msg,"debug");
        }
        if(isLogEnable)
            System.out.println(msg);
    }

    public void error(String msg)
    {
        System.err.println("ERROR!!!"+this.className+" : "+msg);
        if(isErrorLogEnableInFile)
        {
            this.write(this.className+" : "+msg,"error");
        }
    }

    public void error(String msg, boolean flag)
    {
        System.err.println("ERROR!!!"+this.className+" : "+msg);
        if(flag)
        {
            this.write(this.className+" : "+msg,"error");
        }
    }

    public void sqlError(String msg)
    {
        System.err.println("ERROR!!!"+this.className+" : "+msg);
        if(isErrorLogEnableInFile)
        {
            this.write(this.className+" : "+msg,"sql");
        }
    }

    public void sqlError(String msg, boolean flag)
    {
        System.err.println("ERROR!!!"+this.className+" : "+msg);
        if(flag)
        {
            this.write(this.className+" : "+msg,"sql");
        }
    }

    public void enableLog()
    {
        this.isLogEnable    = true;
    }
    public void disableLog()
    {
        this.isLogEnable    = false;
    }
    public void enableLogInFile()
    {
        this.isLogEnableInFile = true;
    }
    public void enableErrorLogInFile()
    {
        this.isErrorLogEnableInFile = true;
    }
    public void disableLogInFile()
    {
        this.isLogEnableInFile = false;
    }

    public void write(String message, String msgType)
    {
        String logPath = "";
        try
        {
            //change by yousuf on 06-01-2011
            Utilities xbrlUtils = new Utilities();
            logPath = xbrlUtils.getPropertiesByKey("SERVER_LOGS_DIR");
            String today    = xbrlUtils.getSystemCurrentDate("yyyy-MM-dd#HH:mm:ss");
            String strDate  = today.split("#")[0];
            String strTime  = today.split("#")[1];

            xbrlUtils.writeFileContents(logPath+msgType+"-log-"+strDate+".txt", strTime+" => "+message+"\n", true);
        }
        catch (Exception ex)
        {
            System.err.println("ERROR in LOGWRITER to Write. Log Dir: "+logPath);
            System.err.println("EXCEPTION: "+ex.toString());
            //ex.printStackTrace();
        }
    }

    public static void writeLog(String message, String msgType)
    {
        String logPath = "";
        try
        {
            //change by yousuf on 06-01-2011
            Utilities xbrlUtils = new Utilities();
            logPath = xbrlUtils.getPropertiesByKey("SERVER_LOGS_DIR");
            String today    = xbrlUtils.getSystemCurrentDate("yyyy-MM-dd#HH:mm:ss");
            String strDate  = today.split("#")[0];
            String strTime  = today.split("#")[1];

            xbrlUtils.writeFileContents(logPath+msgType+"-log-"+strDate+".txt", strTime+" => "+message+"\n", true);
        }
        catch (Exception ex)
        {
            System.out.println("ERROR in LOGWRITER to Write. Log Dir: "+logPath);
            System.out.println("EXCEPTION: "+ex.toString());
            //ex.printStackTrace();
        }
    }

}
