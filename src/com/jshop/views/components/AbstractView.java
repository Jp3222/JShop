/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.views.components;

import com.jutil.framework.WindowStates;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author juan-campos
 */
public abstract class AbstractView extends JPanel implements WindowStates {

    public AbstractView(LayoutManager ly, Dimension size) throws HeadlessException {
        super(ly, true);
        this.setPreferredSize(size);
        this.setSize(size);
    }

    public AbstractView(Dimension size) {
        this(new BorderLayout(), size);
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

    protected Component getComponent(JPanel content, String name) {
        for (Component i : content.getComponents()) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

}
