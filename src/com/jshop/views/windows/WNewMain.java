/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.views.windows;

import com.jshop.views.components.AbstractWindow;
import com.jshop.views.views.VDashBoard;
import com.jshop.views.views.VNewHome;
import java.awt.BorderLayout;
import javax.swing.JButton;

/**
 *
 * @author juan-campos
 */
public final class WNewMain extends AbstractWindow {

    private final VDashBoard db;
    private final JButton exit_button;
    private final String[] options_names;

    private final WNewLogin login;

    public WNewMain(WNewLogin login) {
        super("JShop", STD_SIZE, DISPOSE_ON_CLOSE);
        this.login = login;
        this.home = new VNewHome();
        this.db = new VDashBoard();
        this.exit_button = new JButton("Cerrar session");
        options_names = new String[]{
            "Inicio",
            "Empleados",
            "Productos",
            "Proveedores",
            "Distribuidores"
        };
        build();
    }

    @Override
    public void build() {
        components();
        events();
        finalState();
        initialState();
    }

    @Override
    public void events() {
        exit_button.addActionListener(e -> {
            this.setVisible(false);
            this.dispose();
            login.setVisible(true);
        });

    }

    @Override
    public void components() {
        db.setExitOption(exit_button);

        for (String i : options_names) {
            JButton b = new JButton(i);

            b.setName(i);
            db.addOption(b);
        }

        db.addView(home);
        
        //final, final
        add(db, BorderLayout.CENTER);
    }

    @Override
    public void initialState() {
        db.showView("home");
    }

    @Override
    public void finalState() {
    }
    private final VNewHome home;
}
