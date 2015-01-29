/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xbrl.server.exception;

/**
 *
 * @author yzaman
 */
public interface ExceptionTypes
{
    //Database Related Exception
    int DB_CONNECTION_OPEN_ERROR = 9001;
    int DB_CONNECTION_CLOSE_ERROR =9002;
    int DB_QUERY_ERROR = 9003;
    
    //Authentication Related Exception
    int AUTH_FAILED = 301;
    int INVALID_DATA = 302;
    int UNAUTH_ACCESS = 303;
    int SYSTEM_ERROR = 399;

    //Parsing Related Exception
    int PARSE_FAILED    = 5001;
}
