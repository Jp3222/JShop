/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.views.components;

import java.awt.Dimension;
import java.awt.HeadlessException;
import com.jutil.swingw.modelos.TableModel;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author juan-campos
 */
public class ViewTable extends AbstractView {

    private final TableModel table_model;
    private final JTable table;
    private final JScrollPane scroll_pane;
    private final JScrollBar scroll_bar_h;
    private final JScrollBar scroll_bar_v;

    public ViewTable(int w, int h) throws HeadlessException {
        super(new Dimension(w, h));
        table_model = new TableModel(0);
        //
        table = new JTable(table_model);
        //
        scroll_bar_h = new JScrollBar(JScrollBar.HORIZONTAL);
        scroll_bar_v = new JScrollBar(JScrollBar.VERTICAL);
        //
        scroll_pane = new JScrollPane(table);
        scroll_pane.setHorizontalScrollBar(scroll_bar_h);

        table.setPreferredSize(new Dimension(150, 200));
        table.setShowGrid(true);
        table.getTableHeader().setReorderingAllowed(false);
        this.add(scroll_pane, BorderLayout.CENTER);
    }

}
