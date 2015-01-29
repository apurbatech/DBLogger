/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xbrl.server.exception;

/**
 *
 * @author yzaman
 */
public class XBRLException extends Exception
{
    private String  errorMessage;
    private int     errorCode;

    public XBRLException(int errCode, String errMsg)
    {
        super(errMsg);
        this.errorCode      = errCode;
        this.errorMessage   = errMsg;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
