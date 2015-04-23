package com.xbrl.server.bean;

import com.xbrl.server.bean.SeriesInfo;

/**
 *
 * @author nazmul 11 Janyary 2013
 */
public class ClassInfo {
    public int id;
    public String classId;
    public String className;
    public String classTicker;
    public String classStatus;
    public SeriesInfo seriesInfo;
    public ClassInfo()
    {
        seriesInfo = new SeriesInfo();
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }

    public void setClassTicker(String classTicker) {
        this.classTicker = classTicker;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeriesInfo(SeriesInfo seriesInfo) {
        this.seriesInfo = seriesInfo;
    }

    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public String getClassTicker() {
        return classTicker;
    }

    public int getId() {
        return id;
    }

    public SeriesInfo getSeriesInfo() {
        return seriesInfo;
    }    
}
