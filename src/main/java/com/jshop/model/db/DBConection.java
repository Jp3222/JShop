/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.model.db;

/**
 *
 * @author juan-campos
 */
public class DBConection {

    private final String table_name;
    private final String cols;

    public DBConection(String table_name, String cols) {
        this.table_name = table_name;
        this.cols = cols;
    }

}
