/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.views.views;

import com.jshop.views.components.AbstractView;
import com.jshop.views.components.ViewTable;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author juan-campos
 */
public final class VNewHome extends AbstractView {

    private ViewTable view_table;

    public VNewHome() {
        super(new Dimension(800, 600));
        this.setName("home");
        view_table = new ViewTable(400, 600);
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
    }

    @Override
    public void components() {
        this.add(view_table, BorderLayout.WEST);
    }

    @Override
    public void initialState() {
    }

    @Override
    public void finalState() {
    }
}
