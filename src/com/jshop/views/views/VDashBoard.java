/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.views.views;

import com.jshop.views.components.AbstractView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.jshop.views.components.DBLeftPanel;
import com.jshop.views.components.DBMultiPanel;
import java.awt.CardLayout;
import java.awt.Component;

/**
 *
 * @author juan-campos
 */
public final class VDashBoard extends AbstractView implements DBLeftPanel, DBMultiPanel {

    private final JPanel left_panel;
    private final JPanel multi_panel;
    private JButton exit_button;

    public VDashBoard() {
        super(new Dimension(1000, 600));

        left_panel = new JPanel(new BorderLayout());
        left_panel.setPreferredSize(new Dimension(200, 600));
        multi_panel = new JPanel(new CardLayout());
        multi_panel.setPreferredSize(new Dimension(800, 600));
        
        build();
    }

    @Override
    public void build() {
        components();
        events();
        initialState();
        finalState();
    }

    @Override
    public void components() {
        buildLeftPanel();
        this.add(multi_panel, BorderLayout.CENTER);
    }

    @Override
    public void buildLeftPanel() {
        JLabel image = new JLabel("img");
        image.setPreferredSize(new Dimension(left_panel.getWidth(), 200));
        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setName("image-icon");

        JPanel panel = new JPanel(new GridLayout(8, 1));
        panel.setPreferredSize(new Dimension(left_panel.getWidth(), 200));
        panel.setName("options-panel");

        left_panel.add(image, BorderLayout.NORTH);

        left_panel.add(panel, BorderLayout.CENTER);
        //left_panel.add(new JSeparator(JSeparator.VERTICAL),BorderLayout.EAST);
        this.add(left_panel, BorderLayout.WEST);
    }

    @Override
    public JPanel getLetfPanel() {
        return left_panel;
    }

    @Override
    public void addOption(JButton option) {
        JPanel options_panels = (JPanel) left_panel.getComponent(1);
        options_panels.add(option);
    }

    @Override
    public void setImg(Icon img) {
        JLabel icon = (JLabel) left_panel.getComponent(0);
        if (icon.getText() != null) {
            icon.setText(null);
            icon.setIcon(img);
        }
    }

    @Override
    public void setExitOption(JButton option) {
        this.exit_button = option;
        this.exit_button.setPreferredSize(new Dimension(left_panel.getWidth(), 30));
        this.exit_button.setName("exit-button");
        this.left_panel.add(exit_button, BorderLayout.SOUTH);
    }

    @Override
    public JPanel getMultiPanel() {
        return multi_panel;
    }

    @Override
    public void setHome(JPanel home) {
        CardLayout ly = (CardLayout) multi_panel.getLayout();
        if (home.getName() == null) {
            home.setName("home");
        }
        ly.show(multi_panel, home.getName());
    }

    @Override
    public void setHome(int index) {
        JPanel home = (JPanel) multi_panel.getComponent(index);
        CardLayout ly = (CardLayout) multi_panel.getLayout();
        if (home.getName() == null) {
            home.setName("home");
        }
        ly.show(multi_panel, home.getName());

    }

    @Override
    public void addView(JPanel view) {
        String name;
        if (view.getName() == null) {
            name = "view %d".formatted(view.getComponentCount() + 1);
            view.setName(name);
        }
        multi_panel.add(view.getName(), view);
    }

    @Override
    public boolean showView(String name) {
       
        boolean exist = false;
        for (Component i : multi_panel.getComponents()) {
            if (i.getName().equals(name)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            return exist;
        }

        CardLayout ly = (CardLayout) multi_panel.getLayout();
        ly.show(multi_panel, name);
        return exist;
    }

    @Override
    public JButton getOption(String name) {
        return (JButton) getComponent(left_panel, name);
    }

    @Override
    public JPanel getView(String name) {
        return (JPanel) getComponent(multi_panel, name);
    }
    
    

}
