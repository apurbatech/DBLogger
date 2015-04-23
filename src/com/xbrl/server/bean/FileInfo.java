/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbrl.server.bean;

import com.xbrl.server.bean.ProjectInfo;
import java.util.Date;

/**
 *
 * @author sunam
 */
public class FileInfo {

    private int     fileId;
    private int     projectId;
    private String  fileName;
    private String  fileUrl;
    private String  label;
    private Date    createDate;
    private Date    lastUpdate;
    private String  type;
    private String  fileType;
    private boolean  hasHtmlFile;
    private boolean  hasOxmlFile;
    private boolean hasPdfFile;
    private ProjectInfo projectInfo;

    public String documentDescription;
    public String documentType;
    public boolean isExternalHtml;
    private String pdfConfigurationXmlContent = "";

    public void setPdfConfigurationXmlContent(String pdfConfigurationXmlContent) {
        this.pdfConfigurationXmlContent = pdfConfigurationXmlContent;
    }

    public String getPdfConfigurationXmlContent() {
        return pdfConfigurationXmlContent;
    }

    public boolean isHasPdfFile() {
        return hasPdfFile;
    }

    public void setHasPdfFile(boolean hasPdfFile) {
        this.hasPdfFile = hasPdfFile;
    }    
    
    public void setIsExternalHtml(boolean isExternalHtml) {
        this.isExternalHtml = isExternalHtml;
    }

    public boolean isIsExternalHtml() {
        return isExternalHtml;
    }

    

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public String getDocumentType() {
        return documentType;
    }



    /**
     * FileInfo Construcation with type file
     */
    public FileInfo()
    {
        this.type = "file";
    }

    public FileInfo(String label)
    {
        this.label = label;
    }

    /**
     * return file id
     * @return
     */
    public int getFileId() {
        return fileId;
    }

    /**
     * set file id
     * @param fileId
     */
    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    /**
     * @return the projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileUrl
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * @param fileUrl the fileUrl to set
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the lastUpdate
     */
    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * @param lastUpdate the lastUpdate to set
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the projectInfo
     */
    public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    /**
     * @param projectInfo the projectInfo to set
     */
    public void setProjectInfo(ProjectInfo projectInfo) {
        this.projectInfo = projectInfo;
    }

    /**
     * @return the hasHtmlFile
     */
    public boolean getHasHtmlFile() {
        return hasHtmlFile;
    }

    /**
     * @param hasHtmlFile the hasHtmlFile to set
     */
    public void setHasHtmlFile(boolean hasHtmlFile) {
        this.hasHtmlFile = hasHtmlFile;
    }

    /**
     * @return the hasOxmlFile
     */
    public boolean getHasOxmlFile() {
        return hasOxmlFile;
    }

    /**
     * @param hasOxmlFile the hasOxmlFile to set
     */
    public void setHasOxmlFile(boolean hasOxmlFile) {
        this.hasOxmlFile = hasOxmlFile;
    }

    /**
     * @return the fileType
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public FileInfo clone()
    {
        FileInfo fileInfo = new FileInfo();
        
        fileInfo.setCreateDate(createDate);
        fileInfo.setDocumentDescription(documentDescription);
        fileInfo.setDocumentType(documentType);
        fileInfo.setFileId(fileId);
        fileInfo.setFileName(fileName);
        fileInfo.setFileType(fileType);
        fileInfo.setFileUrl(fileUrl);
        fileInfo.setHasHtmlFile(hasHtmlFile);
        fileInfo.setHasOxmlFile(hasOxmlFile);
        fileInfo.setHasPdfFile(hasPdfFile);
        fileInfo.setIsExternalHtml(isExternalHtml);
        fileInfo.setLabel(label);
        fileInfo.setLastUpdate(lastUpdate);
        fileInfo.setProjectId(projectId);
        fileInfo.setProjectInfo(projectInfo);
        fileInfo.setType(type);
        
        return fileInfo;
    }
    
    @Override
    public String toString()
    {
        String strOutput = "";
        strOutput   += "fileId: "+fileId+", projectId: "+projectId+", fileName: "+fileName+", fileUrl: "+fileUrl+", \n";
        strOutput   += "label: "+label+", createDate: "+createDate+", lastUpdate: "+lastUpdate+", type: "+type+", \n";
        strOutput   += "fileType: "+fileType+", hasHtmlFile: "+hasHtmlFile+", hasOxmlFile: "+hasOxmlFile+", hasPdfFile: "+hasPdfFile+",  \n";
        strOutput   += "isExternalHtml: "+isExternalHtml+", documentType: "+documentType+", documentDescription: "+documentDescription;
        return strOutput;
    }
}
