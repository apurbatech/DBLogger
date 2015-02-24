/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xbrl.server.bean;

/**
 *
 * @author Nazmul
 */
public class AccessModule {
    public int accessModuleId;
    public String accessModuleName;
    public String accessModuleDisplayName;

    public AccessModule(){

    }

    /**
     * @param accessModuleId the accessModuleId to set
     */
    public void setAccessModuleId(int accessModuleId){
        this.accessModuleId = accessModuleId;
    }

    /**
     * @return the accessModuleId
     */
    public int getAccessModuleId(){
        return accessModuleId;
    }

    /**
     * @param accessModuleName the accessModuleName to set
     */
    public void setAccessModuleName(String accessModuleName){
        this.accessModuleName = accessModuleName;
    }

    /**
     * @return the accessModuleName
     */
    public String getAccessModuleName(){
        return accessModuleName;
    }

    /**
     * @param accessModuleDisplayName the accessModuleDisplayName to set
     */
    public void setAccessModuleDisplayName(String accessModuleDisplayName){
        this.accessModuleDisplayName = accessModuleDisplayName;
    }

    /**
     * @return the accessModuleDisplayName
     */
    public String getAccessModuleDisplayName(){
        return accessModuleDisplayName;
    }

}
