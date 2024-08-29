/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.controllers;

import com.jutil.jbd2.conexion.DBConnection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan-campos
 */
public class EmployeesController {

    private static final String LOGIN_QUERY = "SELECT id FROM employees WHERE user = '%s' and password = '%s'";

    public static boolean login(String user, String password) {
        boolean result = false;
        try {
            DBConnection db = DBConnection.getInstance();
            ResultSet rs = db.getQuery(String.format(LOGIN_QUERY, user, password));
            result = rs.next();
            if (result) {
                /**
                 * Codigo para guardar la info del usuario
                 */
            }
            result = true;
        } catch (Exception ex) {
            Logger.getLogger(EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * 
     * @param args conjunto de parametos
     * @return true si el usuario local existe
     */
//    public static boolean localUser(String... args) {
//        
//    }
}
