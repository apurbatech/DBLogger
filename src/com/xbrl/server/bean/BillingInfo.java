package com.xbrl.server.bean;
/**
 *
 * @author nazmul on 2nd April 2015
 */
public class BillingInfo {
    public int billingId;
    public int userId;
    public int projectId;
    public int fileId;
    public int billingTypeId;
    public float price;
    public int totalPages;
    public int totalWords;
    
    public BillingInfo()
    {

    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public void setBillingTypeId(int billingTypeId) {
        this.billingTypeId = billingTypeId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBillingId() {
        return billingId;
    }

    public int getBillingTypeId() {
        return billingTypeId;
    }

    public int getFileId() {
        return fileId;
    }

    public float getPrice() {
        return price;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public int getUserId() {
        return userId;
    }
}
