/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xbrl.server.bean;

/**
 *
 * @author Nazmul
 */
public class PriceTypeInfo {
    public int priceTypeId;
    public String priceTypeName;
    public String displayPriceTypeName;
    public float unitPrice;
    public PriceTypeInfo(){

    }

    /**
     * @param priceTypeId the priceTypeId to set
     */
    public void setpriceTypeId(int priceTypeId){
        this.priceTypeId = priceTypeId;
    }

    /**
     * @return the priceTypeId
     */
    public int getPriceTypeId(){
        return priceTypeId;
    }
    /**
     * @param priceTypeName the priceTypeName to set
     */
    public void setPriceTypeName(String priceTypeName){
        this.priceTypeName = priceTypeName;
    }

    /**
     * @return the priceTypeName
     */
    public String getPriceTypeName(){
        return priceTypeName;
    }

    /**
     * @param displayPriceTypeName the displayPriceTypeName to set
     */
    public void setDisplayPriceTypeName(String displayPriceTypeName){
        this.displayPriceTypeName = displayPriceTypeName;
    }

    /**
     * @return the displayPriceTypeName
     */
    public String getDisplayPriceTypeName(){
        return displayPriceTypeName;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(float unitPrice){
        this.unitPrice = unitPrice;
    }

    /**
     * @return the unitPrice
     */
    public float getUnitPrice(){
        return unitPrice;
    }
}
