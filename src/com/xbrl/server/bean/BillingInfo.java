package com.xbrl.server.bean;
/**
 *
 * @author nazmul on 2nd April 2015
 */
public class BillingInfo {
    public int billingId;
    public int userId;
    public int projectId;
    public String projectName;
    public int fileId;
    public String fileName;
    public int companyId;
    public int billingTypeId;
    public String billingTypeTitle;
    public float price;
    public int totalPages;
    public int totalWords;
    public String createdDate;
    
    public BillingInfo()
    {

    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public void setBillingTypeId(int billingTypeId) {
        this.billingTypeId = billingTypeId;
    }

    public void setBillingTypeTitle(String billingTypeTitle) {
        this.billingTypeTitle = billingTypeTitle;
    }
    
    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    
    public int getBillingId() {
        return billingId;
    }

    public int getBillingTypeId() {
        return billingTypeId;
    }

    public String getBillingTypeTitle() {
        return billingTypeTitle;
    }
    
    public int getFileId() {
        return fileId;
    }

    public int getCompanyId() {
        return companyId;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }    
}
