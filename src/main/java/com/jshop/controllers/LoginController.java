/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.controllers;

import com.jshop.views.windows.WLogin;
import com.jshop.views.windows.WMain;
import java.awt.event.ActionEvent;

/**
 *
 * @author juan-campos
 */
public class LoginController extends WindowController {

    private final WLogin view;
    private WMain main_view;

    public LoginController(WLogin view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login" ->
                login();
            case "config" ->
                config();
            default ->
                defaultCase(view, e.getActionCommand(), null);
        }
    }

    public void login() {
        
        main_view = new WMain(view);
        main_view.setVisible(true);
        //
        view.setVisible(false);
        view.dispose();
    }

    public void config() {
    }

}
