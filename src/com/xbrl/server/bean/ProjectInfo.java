/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbrl.server.bean;

import com.xbrl.server.bean.CompanyInfo;
import com.xbrl.server.bean.FileInfo;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author sunam
 */
public class ProjectInfo {

    public int projectId;
    public int userId;
    public int profileId;
    public String projectName;
    public String periodFrom;
    public String periodTo;
    public String label;
    public String type;
    public String createDate;
    public String lastUpdate;
    public String recentUpdate;
    public String rootFileName;
    public String baseTaxonomyFileName;
    public List<FileInfo> children;
    public ArrayList<ProjectInfo> childProject;
    public ProjectInfo parent;

    public String fileUrl;

    public boolean archived;

    public int companyId;
    public String companyName;
    public int yearId;
    public String yearName;
    public int quarterId;
    public String quarterName;
    public int fileTypeId;
    public String fileTypeName;
    public int createdUserId;

    public boolean amendment;
    public String amendmentDescription;
    public boolean goodStanding;
    public String classA;
    public String classB;
    public String outstanding;
    public String commonStockDate;
    public String marketValue;
    public String publicFloatDate;

    public String projectDisplayName;

    public String edgarCompanyName;

    public int  instanceFiscalPeriodFocusId;
    public String  instanceFiscalPeriodFocusName;

    public int taxonomyId;
    public String taxonomyIdLabel;

    public int projectCategoryId;
    public String projectCategoryName;
    public int newsfileJobId;
    
    public String tempPeriodTo;
    public String tempTikcerName;
    
    public boolean riskReturn;
    public String prospectusDate;
    public String documentCreationDate;
    public String documentEffectiveDate;    
    public CompanyInfo companyInfo;
    
    public ProjectInfo()
    {
        this.type  = "";
        childProject = new ArrayList<ProjectInfo>();
        children = new ArrayList<FileInfo>();
        companyInfo = new CompanyInfo();
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }
    
    public void setDocumentCreationDate(String documentCreationDate) {
        this.documentCreationDate = documentCreationDate;
    }

    public void setDocumentEffectiveDate(String documentEffectiveDate) {
        this.documentEffectiveDate = documentEffectiveDate;
    }

    public void setProspectusDate(String prospectusDate) {
        this.prospectusDate = prospectusDate;
    }

    public void setRiskReturn(boolean riskReturn) {
        this.riskReturn = riskReturn;
    }

    public String getDocumentCreationDate() {
        return documentCreationDate;
    }

    public String getDocumentEffectiveDate() {
        return documentEffectiveDate;
    }

    public String getProspectusDate() {
        return prospectusDate;
    }

    public boolean isRiskReturn() {
        return riskReturn;
    }
    
    public void setClassA(String classA) {
        this.classA = classA;
    }

    public void setClassB(String classB) {
        this.classB = classB;
    }

    public String getClassA() {
        return classA;
    }

    public String getClassB() {
        return classB;
    }
    
    public void setProjectCategoryId(int projectCategoryId) {
        this.projectCategoryId = projectCategoryId;
    }

    public void setProjectCategoryName(String projectCategoryName) {
        this.projectCategoryName = projectCategoryName;
    }

    public int getProjectCategoryId() {
        return projectCategoryId;
    }

    public String getProjectCategoryName() {
        return projectCategoryName;
    }

    public int getInstanceFiscalPeriodFocusId() {
        return instanceFiscalPeriodFocusId;
    }

    public String getInstanceFiscalPeriodFocusName() {
        return instanceFiscalPeriodFocusName;
    }

    public void setInstanceFiscalPeriodFocusId(int instanceFiscalPeriodFocusId) {
        this.instanceFiscalPeriodFocusId = instanceFiscalPeriodFocusId;
    }

    public void setInstanceFiscalPeriodFocusName(String instanceFiscalPeriodFocusName) {
        this.instanceFiscalPeriodFocusName = instanceFiscalPeriodFocusName;
    }

    public int getQuarterId() {
        return quarterId;
    }

    /**
     * return project id
     * @return
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * project id
     * @param projectId
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * return user id
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     * return user id
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * return project name
     * @return
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * set project name
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;

    }

    /**
     * return profile id
     * @return
     */
    public int getProfileId() {
        return profileId;
    }

    /**
     * set profile id
     * @param profileId
     */
    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    /**
     * get project period from
     * @return
     */
    public String getPeriodFrom() {
        return periodFrom;
    }

    /**
     * set project period from
     * @param periodFrom
     */
    public void setPeriodFrom(String periodFrom) {
        this.periodFrom = periodFrom;
    }

    /**
     * return project perid to
     * @return
     */
    public String getPeriodTo() {
        return periodTo;
    }

    /**
     * set project period to
     * @param periodTo
     */
    public void setPeriodTo(String periodTo) {
        this.periodTo = periodTo;

    }

    /**
     * return create date
     * @return
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * set create date.
     * @param createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;

    }

    /**
     * return last update date
     * @return
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * set last update date
     * @param lastUpdate
     */
    public void setLastUpdate(String lastUpdate) {
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
     * @return the children
     */
    public List<FileInfo> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<FileInfo> children) {
        this.children = children;
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
     * @return the rootFileName
     */
    public String getRootFileName() {
        return rootFileName;
    }

    /**
     * @param rootFileName the rootFileName to set
     */
    public void setRootFileName(String rootFileName) {
        this.rootFileName = rootFileName;
    }

    /**
     * @return the recentUpdate
     */
    public String getRecentUpdate() {
        return recentUpdate;
    }

    /**
     * @param recentUpdate the recentUpdate to set
     */
    public void setRecentUpdate(String recentUpdate) {
        this.recentUpdate = recentUpdate;
    }

    public void setChildProject(ArrayList<ProjectInfo> childProject){
        this.childProject = childProject;
    }

    public ArrayList<ProjectInfo> getChildProject(){
        return this.childProject;
    }

    public void setFileUrl(String fileUrl){
        this.fileUrl = fileUrl;
    }

    public String getFileUrl(){
        return this.fileUrl;
    }

    public void setParent(ProjectInfo parent){
        this.parent = parent;
    }

    public ProjectInfo getParent(){
        return parent;
    }

    public void setArchived(boolean archived){
        this.archived = archived;
    }

    public boolean getArchived(){
        return archived;
    }

    public void setCompanyId(int companyId){
        this.companyId = companyId;
    }

    public int getCompanyId(){
        return companyId;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return companyName;
    }

    public void setYearId(int yearId){
        this.yearId = yearId;
    }

    public int getYearId(){
        return yearId;
    }

    public void setYearName(String yearName){
        this.yearName = yearName;
    }

    public String getYearName(){
        return yearName;
    }

    public void setQuarterId(int quarterId){
        this.quarterId = quarterId;
    }

    public int getquarterId(){
        return quarterId;
    }

    public void setQuarterName(String quarterName){
        this.quarterName = quarterName;
    }

    public String getQuarterName(){
        return quarterName;
    }

    public void setFileTypeId(int fileTypeId){
        this.fileTypeId = fileTypeId;
    }

    public int getFileTypeId(){
        return fileTypeId;
    }

    public void setFileTypeName(String fileTypeName){
        this.fileTypeName = fileTypeName;
    }

    public String getFileTypeName(){
        return fileTypeName;
    }

    public void setCreatedUserId(int createdUserId){
        this.createdUserId = createdUserId;
    }

    public int getCreatedUserId(){
        return createdUserId;
    }

    public void setAmendment(boolean amendment){
        this.amendment = amendment;
    }

    public boolean getAmendment(){
        return amendment;
    }

    public void setAmendmentDescription(String amendmentDescription){
        this.amendmentDescription = amendmentDescription;
    }

    public String getAmendmentDescription(){
        return amendmentDescription;
    }

    public void setGoodStanding(boolean goodStanding){
        this.goodStanding = goodStanding;
    }

    public boolean getGoodStanding(){
        return goodStanding;
    }

    public void setOutstanding(String outstanding){
        this.outstanding = outstanding;
    }

    public String getOutstanding(){
        return outstanding;
    }

    public void setCommonStockDate(String commonStockDate){
        this.commonStockDate = commonStockDate;
    }

    public String getCommonStockDate(){
        return commonStockDate;
    }

    public void setMarketValue(String marketValue){
        this.marketValue = marketValue;
    }

    public String getMarketValue(){
        return marketValue;
    }

    public void setPublicFloatDate(String publicFloatDate){
        this.publicFloatDate = publicFloatDate;
    }

    public String getPublicFloatDate(){
        return publicFloatDate;
    }

    public void setProjectDisplayName(String projectDisplayName){
        this.projectDisplayName = projectDisplayName;
    }

    public String getProjectDisplayName(){
        return projectDisplayName;
    }

    /**
     * @return the baseTaxonomyFileName
     */
    public String getBaseTaxonomyFileName() {
        return baseTaxonomyFileName;
    }

    /**
     * @param baseTaxonomyFileName the baseTaxonomyFileName to set
     */
    public void setBaseTaxonomyFileName(String baseTaxonomyFileName) {
        this.baseTaxonomyFileName = baseTaxonomyFileName;
    }

    public void setEdgarCompanyName(String edgarCompanyName){
        this.edgarCompanyName = edgarCompanyName;
    }

    public String getEdgarCompanyName(){
        return edgarCompanyName;
    }

    public void setTaxonomyId(int taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public void setTaxonomyIdLabel(String taxonomyIdLabel) {
        this.taxonomyIdLabel = taxonomyIdLabel;
    }

    public int getTaxonomyId() {
        return taxonomyId;
    }

    public String getTaxonomyIdLabel() {
        return taxonomyIdLabel;
    }
    
    public void setNewsfileJobId(int newsfileJobId) {
        this.newsfileJobId = newsfileJobId;
    }

    public int getNewsfileJobId() {
        return newsfileJobId;
    }

    public String getTempPeriodTo() {
        return tempPeriodTo;
    }

    public void setTempPeriodTo(String tempPeriodTo) {
        this.tempPeriodTo = tempPeriodTo;
    }

    public String getTempTikcerName() {
        return tempTikcerName;
    }

    public void setTempTikcerName(String tempTikcerName) {
        this.tempTikcerName = tempTikcerName;
    }

    
    @Override
    public String toString()
    {
        String strOutput = "";
        strOutput   += "projectId: "+projectId+", userId: "+userId+", profileId: "+profileId+", projectName: "+projectName+", \n";
        strOutput   += "periodFrom: "+periodFrom+", periodTo: "+periodTo+", label: "+label+", type: "+type+", \n";
        strOutput   += "rootFileName: "+rootFileName+", baseTaxonomyFileName: "+baseTaxonomyFileName+", fileUrl: "+fileUrl+", archived: "+archived+", \n";
        strOutput   += "companyId: "+companyId+", companyName: "+companyName+", yearId: "+yearId+", yearName: "+yearName+", \n";
        strOutput   += "quarterId: "+quarterId+", quarterName: "+quarterName+", fileTypeId: "+fileTypeId+", fileTypeName: "+fileTypeName+", \n";
        strOutput   += "amendment: "+amendment+", goodStanding: "+goodStanding+", classA: "+classA+", classB: "+classB+", outstanding: "+outstanding+", commonStockDate: "+commonStockDate+", \n";
        strOutput   += "marketValue: "+marketValue+", publicFloatDate: "+publicFloatDate+", projectDisplayName: "+projectDisplayName+", edgarCompanyName: "+edgarCompanyName+", \n";
        strOutput   += "taxonomyId: "+taxonomyId+", taxonomyIdLabel: "+taxonomyIdLabel+", instanceFiscalPeriodFocusId: "+instanceFiscalPeriodFocusId+", instanceFiscalPeriodFocusName: "+instanceFiscalPeriodFocusName;
        return strOutput;
    }
}