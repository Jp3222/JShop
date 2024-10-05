/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.views.components;

import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author juan-campos
 */
public interface DBLeftPanel {

    public void buildLeftPanel();

    public JPanel getLetfPanel();

    public void addOption(JButton option);

    public void setImg(Icon img);

    public void setExitOption(JButton option);

    public JButton getOption(String name);
    
    
}
