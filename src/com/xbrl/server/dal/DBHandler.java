/*
 * DBHandler.java
 *
 * Created on January 27, 2010, 3:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xbrl.server.dal;

/**
 *
 * @author Yousuf Zaman
 */

import com.xbrl.server.exception.ExceptionTypes;
import com.xbrl.server.exception.XBRLException;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBHandler
{
    private Connection connection;
    private int lastInsertedId;

    /**
     * Return a connection.
     * @return Connection
     **/
    public Connection getConnection()
    {
        //<editor-fold defaultstate="collapsed" desc="Return Connection">
        return connection;
        //</editor-fold>
    }

    /**
     * Set the COnnection.
     * @param connection
     **/
    public void setConnection(Connection connection)
    {
        //<editor-fold defaultstate="collapsed" desc="Set SQL Connection">
        this.connection = connection;
        //</editor-fold>
    }

    public Connection verifyConnection(Connection conn)
    {
        try
        {
            if(conn==null || conn.isClosed())
            {
                 conn = DBConnection.newConnection().getConnection();
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return conn;
    }

    /**
     * Fetch Data From Database and Return Data as Result Set.
     * @param sql
     * @return Result Set of Data
     **/
    public ResultSet select(String sql)
    {
        //<editor-fold defaultstate="collapsed" desc="Select Data From Database">
        try
        {
            connection = verifyConnection(connection);
            //LogWriter.writeLog(sql,"sqlselect");
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //Utilities.generateQueryLog("sql_select", sql, "192.168.152.225");
            return stmt.executeQuery(sql);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
        //</editor-fold>
    }

    /**
     * Insert Data into Database and return insert status
     * @param sql
     * @return insert status
     **/
    public int insert(String sql)
    {
        //<editor-fold defaultstate="collapsed" desc="Execute Insert Statment.">
        int updated = 0;
        try
        {
            connection = verifyConnection(connection);
            Statement stmt=connection.createStatement();
            updated = stmt.executeUpdate(sql);
            ResultSet rs=stmt.getGeneratedKeys();
            
            if(rs.next())
                this.lastInsertedId=rs.getInt(1);
            stmt.close();
            rs.close();
            return updated;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return updated;
        //</editor-fold>
    }

    /**
     * Insert data into database and return Last inserted id
     * @param sql Sql String
     * @param seqName Sequence name for the table
     * @return
     */
    public int insert(String sql, String seqName)
    {
        //<editor-fold defaultstate="collapsed" desc="Execute Insert Statment.">
        int updated = 0;
        try
        {
            connection = verifyConnection(connection);
            Statement stmt = connection.createStatement();
            updated = stmt.executeUpdate(sql);
            stmt.close();
            Statement statement = connection.createStatement();

            ResultSet generatedKeys = statement.executeQuery("SELECT currval('"+seqName+"')");
            if (generatedKeys.next()) {
                this.lastInsertedId = generatedKeys.getInt(1);
            }
            statement.close();
            generatedKeys.close();
            return this.lastInsertedId;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return this.lastInsertedId;
        //</editor-fold>
    }

    /**
     * Insert data into database and return Last inserted id
     * @param sql Sql String
     * @param seqName Sequence name for the table
     * @return
     */
    public int insertTransactional(String sql, String seqName) throws XBRLException
    {
        //<editor-fold defaultstate="collapsed" desc="Execute Insert Statment.">
        int updated = 0;
        try
        {
            connection = verifyConnection(connection);
            Statement stmt = connection.createStatement();
            updated = stmt.executeUpdate(sql);
            stmt.close();
            Statement statement = connection.createStatement();

            ResultSet generatedKeys = statement.executeQuery("SELECT currval('"+seqName+"')");
            if (generatedKeys.next()) {
                this.lastInsertedId = generatedKeys.getInt(1);
            }
            statement.close();
            generatedKeys.close();
            return this.lastInsertedId;
        }
        catch(SQLException ex)
        {
            //ex.printStackTrace();
            System.out.println("SQLException: "+ex.getMessage());
            throw new XBRLException(ExceptionTypes.DB_QUERY_ERROR, ex.getMessage());
        }
        catch(Exception ex)
        {
            //ex.printStackTrace();
            System.out.println("DBHandler Exception: "+ex.getMessage());
            throw new XBRLException(ExceptionTypes.DB_QUERY_ERROR, ex.getMessage());
        }
        //</editor-fold>
    }

    /**
     * Execute Update statement. Update data with database.
     * @param sql
     * @return Update status
     **/
    public int update(String sql)
    {
        //<editor-fold defaultstate="collapsed" desc="Update data with database">
        int updated = 0;
        try
        {
            connection = verifyConnection(connection);
            Statement stmt = connection.createStatement();
            //Utilities.generateQueryLog("query", sql, "192.168.152.225");
            updated=stmt.executeUpdate(sql);
            stmt.close();
            return updated;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return updated;
        //</editor-fold>
    }

    /**
     * Execute Update statement. Update data with database.
     * @param sql
     * @return Update status
     **/
    public int delete(String sql)
    {   
        //<editor-fold defaultstate="collapsed" desc="Delete data with database">
        int updated = 0;
        try
        {
            connection = verifyConnection(connection);
            Statement stmt=connection.createStatement();
            //Utilities.generateQueryLog("query", sql, "192.168.152.225");
            updated=stmt.executeUpdate(sql);
            stmt.close();
            return updated;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return updated;
        //</editor-fold>
    }

    /**
     * Excecute Sql Command
     * @param sql
     * @return
     */
    public boolean execute(String sql)
    {
        //<editor-fold defaultstate="collapsed" desc="Execute Sql ">
        boolean stat = false;
        try
        {
            connection = verifyConnection(connection);
            Statement stmt = connection.createStatement();
            stat = stmt.execute(sql);
            stmt.close();
            return stat;
        }
        catch(SQLException ex)
        {
            System.out.println("SQLException: "+ex.getMessage());
            //ex.printStackTrace();
        }
        catch(Exception ex)
        {
            System.out.println("Exception: "+ex.getMessage());
            ex.printStackTrace();
        }
        return stat;
        //</editor-fold>
    }

    public boolean executeTransactional(String sql) throws XBRLException
    {
        //<editor-fold defaultstate="collapsed" desc="Execute Sql Query with exception throws ">
        boolean stat = false;
        try
        {
            connection = verifyConnection(connection);
            Statement stmt = connection.createStatement();
            stat = stmt.execute(sql);
            stmt.close();
            return stat;
        }
        catch(SQLException ex)
        {
            System.out.println("SQLException: "+ex.getMessage());
            throw new XBRLException(ExceptionTypes.DB_QUERY_ERROR, ex.getMessage());
            
            //ex.printStackTrace();
        }
        catch(Exception ex)
        {
            System.out.println("Exception: "+ex.getMessage());
            throw new XBRLException(ExceptionTypes.DB_QUERY_ERROR, ex.getMessage());
        }
        //</editor-fold>
    }
    
    /**
     * Return Last Inserted data into database with insert operation
     * @return int inserted id
     **/
    public int getLastInsertedId()
    {
        //<editor-fold defaultstate="collapsed" desc="Last Inserted Id">
        return lastInsertedId;
        //</editor-fold>
    }

    /**
     * Close the given result set and statement.
     * @param rs
     **/
    public void closeResult(ResultSet rs)
    {
        //<editor-fold defaultstate="collapsed" desc="Close Result Set and Statement">
        try
        {
            rs.getStatement().close();
            rs.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //</editor-fold>
    }

    /**
     * Close connection
     **/
    public void closeConnection()
    {
        //<editor-fold defaultstate="collapsed" desc="Close the Connection">
        try
        {
            this.connection.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //</editor-fold>
    }

    /**
     * Start Transaction for Transactional Operation
     **/
    public void startTransection()
    {
        //<editor-fold defaultstate="collapsed" desc="Start Transactin for Transactional Operation">
        try
        {
            connection = verifyConnection(connection);
            connection.setAutoCommit(false);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //</editor-fold>
    }

    /**
     * Perform commint operation for transactional operation.
     **/
    public void commit()
    {
        //<editor-fold defaultstate="collapsed" desc="Commit Transactional Operation">
        try
        {
            connection = verifyConnection(connection);
            this.connection.commit();
        }

        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //</editor-fold>
    }

    /**
     * Perform commint operation for transactional operation.
     **/
    public void setAutoCommit(boolean flag)
    {
        //<editor-fold defaultstate="collapsed" desc="Set Auto Commit Transactional Operation">
        try
        {
            connection = verifyConnection(connection);
            this.connection.setAutoCommit(flag);
        }

        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //</editor-fold>
    }

    /**
     * Rollback the transactional Operation
     **/
    public void rollBack()
    {
        //<editor-fold defaultstate="collapsed" desc="Rollback the Transactional Operation">
        try
        {
            connection = verifyConnection(connection);
            this.connection.rollback();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //</editor-fold>
    }

    /**
     * Fetch Data From Database and Return Data as Array Listt.
     * @param rs
     * @return Array List
     **/
    public ArrayList resultSetToArrayList(ResultSet rs)
    {
        //<editor-fold defaultstate="collapsed" desc="Select and resut arraylist">
        ArrayList rsList = null;
        try
        {
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            String columnList[] = new String[numberOfColumns];
            for (int i = 0; i < numberOfColumns; i++)
            {
                columnList[i]   = rsmd.getColumnName(i);
            }
            rsList = new ArrayList(numberOfColumns);
            while (rs.next())
            {
                Map colVal = new HashMap();
                for (int i = 1; i<=numberOfColumns; i++)
                {
                    colVal.put(columnList[i], rs.getString(i));
                }
                rsList.add(colVal);
            }
            return rsList;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return rsList;
        //</editor-fold>
    }
}