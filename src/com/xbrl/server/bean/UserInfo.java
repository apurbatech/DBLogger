/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xbrl.server.bean;

import com.xbrl.server.bean.AccessModule;
import com.xbrl.server.bean.PriceTypeInfo;
import java.util.ArrayList;

/**
 *
 * @author yzaman
 */
public class UserInfo
{
    public int     userId;
    public String  userName;
    public String  userPassword;
    public String  createDate;
    public String  lastUpdate;
    public boolean html;
    public boolean xbrl;

    public String userType;
    public boolean active;
    public String userEmail;

    public int totalUser;
    public String subscriptionDateFrom;
    public String subscriptionDateTo;

    public int subscriberId;
    public String subscriberName;

    public String firstName;
    public String lastName;
    public String cellNo;
    public String faxNo;
    public ArrayList<AccessModule> accessModule;
    private int defaultTemplateID;
    private int defaultParagraphID;
    private int defaultGraphicID;
    private int defaultListID;
    
    public String website;

    public boolean paginationEnabled;
    public int pageRange;

    public String cik;
    public String ccc;
    public String password;

    public boolean excludeDetailNote;
    public boolean excludeHATs;
    public boolean excludeInstanceReport;
    
    public String sessionId = "";
    public ArrayList<PriceTypeInfo> priceTypeInfoList = new ArrayList<PriceTypeInfo>();

    public void setPriceTypeInfoList(ArrayList<PriceTypeInfo> priceTypeInfoList) {
        this.priceTypeInfoList = priceTypeInfoList;
    }

    public ArrayList<PriceTypeInfo> getPriceTypeInfoList() {
        return priceTypeInfoList;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    public void setCik(String cik) {
        this.cik = cik;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCcc() {
        return ccc;
    }

    public String getCik() {
        return cik;
    }

    public String getPassword() {
        return password;
    }

    

    public int getPageRange() {
        return pageRange;
    }

    public boolean isPaginationEnabled() {
        return paginationEnabled;
    }

    public void setPageRange(int pageRange) {
        this.pageRange = pageRange;
    }

    public void setPaginationEnabled(boolean paginationEnabled) {
        this.paginationEnabled = paginationEnabled;
    }


    public UserInfo(){
        accessModule = new ArrayList<AccessModule>();
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * password in string format.
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the lastUpdate
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * @param lastUpdate the lastUpdate to set
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @return the html
     */
    public boolean isHtml() {
        return html;
    }

    /**
     * @param html the html to set
     */
    public void setHtml(boolean html) {
        this.html = html;
    }

    /**
     * @return the xbrl
     */
    public boolean isXbrl() {
        return xbrl;
    }

    /**
     * @param xbrl the xbrl to set
     */
    public void setXbrl(boolean xbrl) {
        this.xbrl = xbrl;
    }

    /**
     * @param userType the type of user  to set
     */
    public void setUserType(String userType){
        this.userType = userType;
    }

    /**
     * @return the user type. i.e. super admin or subscriber or user
     */
    public String getUserType(){
        return this.userType;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active){
        this.active = active;
    }

    /**
     * @return whether user is active or not
     */
    public boolean isActive(){
        return this.active;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    /**
     * @return the user Email
     */
    public String getUserEmail(){
        return userEmail;
    }

    /**
     * @param totalUser the total number of users under a subscriber to set
     */
    public void setTotalUser(int totalUser){
        this.totalUser = totalUser;
    }

    /**
     * @return the total number of users for a subscriber
     */
    public int getTotalUser(){
        return this.totalUser;
    }

    /**
     * @param subscriptionDateFrom the subscription date started from
     */
    public void setSubscriptionDateFrom(String subscriptionDateFrom){
        this.subscriptionDateFrom = subscriptionDateFrom;
    }

    /**
     * @return the date, the subscription is taken from this date
     */
    public String getSubscriptionDateFrom(){
        return this.subscriptionDateFrom;
    }


    /**
     * @param subscriptionDateTo the subscription will exist
     */
    public void setSubscriptionDateTo(String subscriptionDateTo){
        this.subscriptionDateTo = subscriptionDateTo;
    }

    /**
     * @return the date, the subscription will be active till this date
     */
    public String getSubscriptionDateTo(){
        return this.subscriptionDateTo;
    }

    /**
     * @param subscriberId the subscriberId of a user to set
     */
    public void setSubscriberId(int subscriberId){
        this.subscriberId = subscriberId;
    }

    /**
     * @return subscriberId, the subscriber id of a user
     */
    public int getSubscriberId(){
        return this.subscriberId;
    }

    /**
     * @param firstName the first name of a user to set
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    

    /**
     * @return firstName, first name  of a user
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * @param lastName the last name of a user to set
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * @return lastName, last name  of a user
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * @param cellNo the cellNo of a user to set
     */
    public void setCellNo(String cellNo){
        this.cellNo = cellNo;
    }

    /**
     * @return cellNo, cellNo of a user
     */
    public String getCellNo(){
        return cellNo;
    }

    /**
     * @param faxNo the faxNo of a user to set
     */
    public void setFaxNo(String faxNo){
        this.faxNo = faxNo;
    }

    /**
     * @return faxNo, faxNo of a user
     */
    public String getFaxNo(){
        return faxNo;
    }

    /**
     * @param accessModule the accessModule of a user to set
     */
    public void setAccessModule(ArrayList<AccessModule> accessModule){
        this.accessModule = accessModule;
    }

    /**
     * @return accessModule, accessModule of a user
     */
    public ArrayList<AccessModule> getAccessModule(){
        return accessModule;
    }

    /**
     * @return the defaultTemplateID
     */
    public int getDefaultTemplateID() {
        return defaultTemplateID;
    }

    /**
     * @param defaultTemplateID the defaultTemplateID to set
     */
    public void setDefaultTemplateID(int defaultTemplateID) {
        this.defaultTemplateID = defaultTemplateID;
    }

    /**
     * @param website the website of a user to set
     */
    public void setWebsite(String website){
        this.website = website;
    }

    /**
     * @return website, website of a user
     */
    public String getWebsite(){
        return website;
    }

    /**
     * @return the defaultParagraphID
     */
    public int getDefaultParagraphID() {
        return defaultParagraphID;
    }

    /**
     * @param defaultParagraphID the defaultParagraphID to set
     */
    public void setDefaultParagraphID(int defaultParagraphID) {
        this.defaultParagraphID = defaultParagraphID;
    }

    /**
     * @return the defaultGraphicID
     */
    public int getDefaultGraphicID() {
        return defaultGraphicID;
    }

    /**
     * @param defaultGraphicID the defaultGraphicID to set
     */
    public void setDefaultGraphicID(int defaultGraphicID) {
        this.defaultGraphicID = defaultGraphicID;
    }

    /**
     * @return the defaultListID
     */
    public int getDefaultListID() {
        return defaultListID;
    }

    /**
     * @param defaultListID the defaultListID to set
     */
    public void setDefaultListID(int defaultListID) {
        this.defaultListID = defaultListID;
    }
    
    public void setExcludeHATs(boolean excludeHATs) {
        this.excludeHATs = excludeHATs;
    }

    public boolean isExcludeHATs() {
        return excludeHATs;
    }
    
    public void setExcludeDetailNote(boolean excludeDetailNote) {
        this.excludeDetailNote = excludeDetailNote;
    }

    public boolean isExcludeDetailNote() {
        return excludeDetailNote;
    }
    
    public void setExcludeInstanceReport(boolean excludeInstanceReport)
    {
        this.excludeInstanceReport = excludeInstanceReport;
    }
    
    public boolean isExcludeInstanceReport()
    {
        return excludeInstanceReport;
    }

    @Override
    public String toString()
    {
        String strOutput = "";
        strOutput   += "userId: "+userId+", userName: "+userName+", html: "+html+", xbrl: "+xbrl+", \n";
        strOutput   += "userType: "+userType+", active: "+active+", userEmail: "+userEmail+", totalUser: "+totalUser+", \n";
        strOutput   += "subscriptionDateFrom: "+subscriptionDateFrom+", subscriptionDateTo: "+subscriptionDateTo+", subscriberId: "+subscriberId+", subscriberName: "+subscriberName+", \n";
        strOutput   += "firstName: "+firstName+", lastName: "+lastName+", cellNo: "+cellNo+", faxNo: "+faxNo+", \n";
        strOutput   += "defaultTemplateID: "+defaultTemplateID+", defaultParagraphID: "+defaultParagraphID+", defaultGraphicID: "+defaultGraphicID+", defaultListID: "+defaultListID+", \n";
        strOutput   += "paginationEnabled: "+paginationEnabled+", pageRange: "+pageRange+", cik: "+cik+", ccc:"+ccc+", website: "+website;
        return strOutput;
    }
}