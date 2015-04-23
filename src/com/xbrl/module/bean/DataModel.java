/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xbrl.module.bean;

/**
 *
 * @author nazmul
 */
public class DataModel {
    public String name;
    public String data;
    public String category;
    public int id;

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public DataModel(){

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }

}
