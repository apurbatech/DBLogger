package com.xbrl.server.bean;

import com.xbrl.server.bean.ClassInfo;
import com.xbrl.server.bean.CompanyInfo;
import com.xbrl.server.bean.UserInfo;
import com.xbrl.server.bean.UserInfo;
import com.xbrl.server.bean.UserInfo;
import java.util.ArrayList;

/**
 *
 * @author nazmul 11 Janyary 2013
 */
public class SeriesInfo {
    public int id;
    public String seriesId;
    public String seriesName;
    public String seriesStatus;
    public CompanyInfo companyInfo;
    public UserInfo userInfo;
    public ArrayList<ClassInfo> classList;
    public SeriesInfo()
    {
        companyInfo = new CompanyInfo();
        userInfo = new UserInfo();
        classList = new ArrayList<ClassInfo>();
    }

    public void setClassList(ArrayList<ClassInfo> classList) {
        this.classList = classList;
    }

    public ArrayList<ClassInfo> getClassList() {
        return classList;
    }
    
    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public void setSeriesStatus(String seriesStatus) {
        this.seriesStatus = seriesStatus;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public int getId() {
        return id;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public String getSeriesStatus() {
        return seriesStatus;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }    
}
