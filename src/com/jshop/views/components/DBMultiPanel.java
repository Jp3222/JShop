/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jshop.views.components;

import javax.swing.JPanel;

/**
 *
 * @author juan-campos
 */
public interface DBMultiPanel {

    JPanel getMultiPanel();

    void setHome(JPanel home);

    void setHome(int index);

    void addView(JPanel view);
    
    boolean showView(String name);
    
    public JPanel getView(String name);

}
