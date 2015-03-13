package com.xbrl.server.bean;

/**
 *
 * @author Nazmul
 */
public class BillInfo {
    public int billId;
    public int userId;
    public int projectId;
    public int fileId;
    public int priceTypeId;
    public float price;
    public BillInfo(){
        
    }

    /**
     * @param billId the billId to set
     */
    public void setBillId(int billId){
        this.billId = billId;
    }

    /**
     * @return the billId
     */
    public int getBillId(){
        return billId;
    }
    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId){
        this.userId = userId;
    }

    /**
     * @return the userId
     */
    public int getUserId(){
        return userId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(int projectId){
        this.projectId = projectId;
    }

    /**
     * @return the projectId
     */
    public int getProjectId(){
        return projectId;
    }

    /**
     * @param fileId the fileId to set
     */
    public void setFileId(int fileId){
        this.fileId = fileId;
    }

    /**
     * @return the fileId
     */
    public int getFileId(){
        return fileId;
    }

    /**
     * @param priceTypeId the priceTypeId to set
     */
    public void setPriceTypeId(int priceTypeId){
        this.priceTypeId = priceTypeId;
    }

    /**
     * @return the priceTypeId
     */
    public int getPriceTypeId(){
        return priceTypeId;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price){
        this.price = price;
    }

    /**
     * @return the price
     */
    public float getPrice(){
        return price;
    }
}
