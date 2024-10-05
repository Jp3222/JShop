/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.views.components;

import com.jutil.framework.WindowStates;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author juan-campos
 */
public abstract class AbstractWindow extends JFrame implements WindowStates {

    /**
     *tamaño estandar de una ventana = w:1000, h:600
     */
    public static Dimension STD_SIZE = new Dimension(1000, 600);

    public AbstractWindow(String title, Dimension size, int close_operation) throws HeadlessException {
        super(title);
        this.setPreferredSize(size);
        this.setSize(size);
        this.setLocationByPlatform(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(close_operation);
        
    }

    public AbstractWindow() throws HeadlessException {
        
    }

    @Override
    public void build() {
    }

    @Override
    public void events() {
    }

    @Override
    public void components() {
    }

    @Override
    public void initialState() {
    }

    @Override
    public void finalState() {
    }

}
