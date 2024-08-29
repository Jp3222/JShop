/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jshop.views.windows;

import com.jshop.controllers.EmployeesController;
import com.jutil.framework.WindowStates;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author juan-campos
 */
public class WLogin extends javax.swing.JFrame implements WindowStates {

    private boolean login_process;

    /**
     * Creates new form WLogin
     */
    public WLogin() {
        initComponents();
        build();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        showPassword = new javax.swing.JCheckBox();
        password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 600));
        setPreferredSize(new java.awt.Dimension(400, 600));

        jLabel1.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inicio de Sesion");
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 40));
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Icono");
        jLabel3.setPreferredSize(new java.awt.Dimension(400, 250));
        jPanel1.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.GridLayout(6, 0));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Usuario");
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel4.add(jLabel4, java.awt.BorderLayout.LINE_START);
        jPanel4.add(user, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("Contraseña");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel5.add(jLabel5, java.awt.BorderLayout.LINE_START);

        showPassword.setText("M");
        jPanel5.add(showPassword, java.awt.BorderLayout.LINE_END);
        jPanel5.add(password, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5);
        jPanel3.add(jLabel6);

        btn_login.setText("Inicio de sesion");
        jPanel3.add(btn_login);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jButton1.setText("C");
        jButton1.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel2.add(jButton1, java.awt.BorderLayout.LINE_START);

        jLabel2.setText("Estado");
        jPanel2.add(jLabel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goToMain() {
        if (login_process) {
            return;
        }

        login_process = true;

        SwingUtilities.invokeLater(() -> {
            main = new WMain(this);
            main.setVisible(true);
        });
        
        setVisible(true);
        dispose();

        login_process = false;
        initialState();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
    private WMain main;

    @Override
    public final void build() {

        components();
        finalState();
        initialState();
        events();
    }

    @Override
    public void events() {
        btn_login.addActionListener(e -> {
            if (!EmployeesController.login(user.getText(), String.valueOf(password.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado");
                return;
            }
            goToMain();
        });

    }

    @Override
    public void components() {
        showPassword.addChangeListener(e -> {
            if (showPassword.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar((char) 0);
                password.setEchoChar('*');
            }
        });

    }

    @Override
    public void initialState() {
        user.setText(null);
        password.setText(null);
        showPassword.setSelected(false);
    }

    @Override
    public void finalState() {
        password.setEchoChar('*');
    }
}
