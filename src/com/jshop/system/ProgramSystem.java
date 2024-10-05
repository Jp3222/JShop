/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.system;

import com.jshop.views.windows.WNewLogin;
import com.jutil.framework.MainSystem;
import com.jutil.jbd.conexion.Conexion;
import com.jutil.jbd2.conexion.DBConnection;
import com.jutil.platf.So;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author juan-campos
 */
public class ProgramSystem implements MainSystem {

    private final static ProgramSystem INSTANCE = new ProgramSystem();

    public static ProgramSystem getINSTANCE() {
        return INSTANCE;
    }

    private ProgramSystem() {
        So.setDefaultLookAndFeel();
    }

    private Conexion connection;

    @Override
    public boolean conectionDB() {
        DBConnection db = null;
        try {
            db = DBConnection.getInstance("jp", "12345", "jdbc:mysql://localhost:3306/jshop");
            if (db.getConnection() == null) {
                System.out.println("NULL");
            }
            if (!db.isValid()) {
                System.out.println("NO VALIDA");
                return false;
            }
            if (!db.isConnection()) {
                System.out.println("NO CONECTADO");
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProgramSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db != null;
    }

    @Override
    public boolean appFiles() {
        return true;
    }

    @Override
    public boolean cache() {
        return true;
    }

    @Override
    public boolean run() {
        SwingUtilities.invokeLater(() -> {
            WNewLogin login = new WNewLogin();
            login.setVisible(true);
        });
        return true;
    }

    @Override
    public boolean openSys() {
        return true;
    }

    @Override
    public boolean closeSys() {
        return true;
    }

}
