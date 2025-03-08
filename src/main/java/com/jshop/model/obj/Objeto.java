/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.model.obj;

import com.jsoftware.jutil.db.conexion.obj.AbstractDBObject;
import java.util.Arrays;

/**
 *
 * @author juan-campos
 */
public class Objeto extends AbstractDBObject {

    public Objeto(String[] data) {
        super(data);
    }

    public String getID() {
        return values[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

}
