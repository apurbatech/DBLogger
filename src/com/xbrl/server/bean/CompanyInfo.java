package com.xbrl.server.bean;

import com.xbrl.server.bean.PriceTypeInfo;
import com.xbrl.server.bean.PriceTypeInfo;
import com.xbrl.server.bean.PriceTypeInfo;
import com.xbrl.server.bean.ProfileInfo;
import com.xbrl.server.bean.SeriesInfo;
import com.xbrl.server.bean.UserInfo;
import com.xbrl.server.bean.UserInfo;
import com.xbrl.server.bean.UserInfo;
import java.util.ArrayList;

/**
 *
 * @author nazmul 8 Janyary 2013
 */
public class CompanyInfo {
    public int companyId;
    public String companyName;
    public boolean isInitiallyCharged;
    public ArrayList<ProfileInfo> profileList;
    public ArrayList<SeriesInfo> seriesList;
    public boolean riskReturn;
    public UserInfo userInfo;
    public String riskReturnHeader;
    public String headings;
    public String captions;
    public String textBlocks;
    public ArrayList<PriceTypeInfo> priceTypeInfoList = new ArrayList<PriceTypeInfo>();
    public CompanyInfo()
    {
        profileList = new ArrayList<ProfileInfo>();
        seriesList = new ArrayList<SeriesInfo>();
        userInfo = new UserInfo();
    }

    public void setPriceTypeInfoList(ArrayList<PriceTypeInfo> priceTypeInfoList) {
        this.priceTypeInfoList = priceTypeInfoList;
    }

    public ArrayList<PriceTypeInfo> getPriceTypeInfoList() {
        return priceTypeInfoList;
    }
    
    public void setCaptions(String captions) {
        this.captions = captions;
    }

    public void setHeadings(String headings) {
        this.headings = headings;
    }

    public void setRiskReturnHeader(String riskReturnHeader) {
        this.riskReturnHeader = riskReturnHeader;
    }

    public void setTextBlocks(String textBlocks) {
        this.textBlocks = textBlocks;
    }

    public String getCaptions() {
        return captions;
    }

    public String getHeadings() {
        return headings;
    }

    public String getRiskReturnHeader() {
        return riskReturnHeader;
    }

    public String getTextBlocks() {
        return textBlocks;
    }
    
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
    
    public void setRiskReturn(boolean riskReturn) {
        this.riskReturn = riskReturn;
    }

    public boolean isRiskReturn() {
        return riskReturn;
    }
    
    public void setSeriesList(ArrayList<SeriesInfo> seriesList) {
        this.seriesList = seriesList;
    }

    public ArrayList<SeriesInfo> getSeriesList() {
        return seriesList;
    }
    
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setIsInitiallyCharged(boolean isInitiallyCharged) {
        this.isInitiallyCharged = isInitiallyCharged;
    }

    public void setProfileList(ArrayList<ProfileInfo> profileList) {
        this.profileList = profileList;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public boolean isIsInitiallyCharged() {
        return isInitiallyCharged;
    }

    public ArrayList<ProfileInfo> getProfileList() {
        return profileList;
    }
    
}
