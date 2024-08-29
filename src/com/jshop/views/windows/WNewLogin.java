/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.views.windows;

import com.jutil.framework.ComponentStates;
import com.jutil.jbd2.conexion.DBConnection;
import com.jutil.swingw.SwFactories.FactorySw;
import com.jutil.swingw.subcomponents.sub.FormComponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author juan-campos
 */
public class WNewLogin extends JFrame implements ComponentStates {

    public WNewLogin() throws HeadlessException {
        super("Inicio de sesion");
        setSize(size_for_windows);
        setPreferredSize(size_for_windows);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));
        pack();
        build();
    }

    @Override
    public final void build() {

        components();
        finalState();
        initialState();
        events();
    }

    @Override
    public void events() {
        show_password.addItemListener(e -> {
            if (show_password.isSelected()) {
                password_field.setEchoChar((char) 0);
            } else {
                password_field.setEchoChar('*');
            }
        });

        login_button.addActionListener(e -> {
           
            initialState();
        });
    }

    @Override
    public void components() {
        try {
            //user icon
            user_icon.setText("Foto");
            user_icon.setHorizontalAlignment(JLabel.CENTER);
            user_icon.setPreferredSize(new Dimension(400, 250));
            //login fields
            JPanel panel_fields = FactorySw.getPanel();
            panel_fields.setLayout(new GridLayout(8, 1, 5, 5));
            FormComponent _user = new FormComponent("usuario: ", BorderLayout.WEST, user_field);
            _user.getLabel().setPreferredSize(standar_text_size);
            _user.setPreferredSize(standar_field_size);
            FormComponent _password = new FormComponent("contraseña: ", BorderLayout.WEST, password_field);
            _password.getLabel().setPreferredSize(standar_text_size);
            _password.setPreferredSize(standar_field_size);
            _password.add(show_password, BorderLayout.EAST);
            panel_fields.add(_user);
            panel_fields.add(_password);
            panel_fields.add(FactorySw.getPanel());
            panel_fields.add(login_button);
            //config option
            JPanel panel_option = FactorySw.getPanel();
            panel_option.setPreferredSize(new Dimension(400, 40));
            panel_option.add(config_button, BorderLayout.WEST);
            String db_state = DBConnection.getInstance().getConnection().isClosed() ? "Desconectado" : "Conectado";
            panel_option.add(new JLabel(String.format(estate_format, db_state)));

            this.add(user_icon, BorderLayout.NORTH);
            this.add(panel_option, BorderLayout.SOUTH);
            this.add(panel_fields, BorderLayout.CENTER);

        } catch (SQLException ex) {
            Logger.getLogger(WNewLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WNewLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialState() {
        user_field.setText(null);
        password_field.setText(null);
        show_password.setSelected(false);
    }

    @Override
    public void finalState() {
        password_field.setEchoChar('*');
    }

    //vars for windows
    private final Dimension size_for_windows = new Dimension(400, 600);
    private final Dimension standar_field_size = new Dimension(300, 30);
    private final Dimension standar_text_size = new Dimension(100, 30);
    
    
    //components
    private final JTextField user_field = new JTextField();
    private final JPasswordField password_field = new JPasswordField();
    private final JCheckBox show_password = new JCheckBox();
    private final JButton login_button = new JButton("Inicio de sesion");
    private final JButton config_button = new JButton("Configuracion");
    private final JLabel user_icon = FactorySw.getSpaceBlanck();
    private final String estate_format = "Estado: %s";
}
