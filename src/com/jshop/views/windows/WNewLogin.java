/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.views.windows;

import com.jshop.views.components.AbstractWindow;
import com.jutil.swingw.SwFactories.FactoryComponents;
import com.jutil.swingw.subcomponents.sub.FormComponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author juan-campos
 */
public final class WNewLogin extends AbstractWindow {

    private final int width = 400;
    private final int height = 400;

    private final JLabel user_icon;
    private final JPanel options_panel;
    private final JPanel sourth_panel;

    public WNewLogin() {
        super("Inicio de sesion", new Dimension(400, 600), EXIT_ON_CLOSE);
        this.setResizable(false);
        user_icon = new JLabel("photo");
        user_icon.setHorizontalAlignment(SwingConstants.CENTER);
        options_panel = new JPanel(new GridLayout(8, 1, 10, 10));
        sourth_panel = new JPanel(new BorderLayout());
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
    public void events() {
        login_button.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                WNewMain o = new WNewMain(this);
                o.setVisible(true);
                initialState();
                this.setVisible(false);
                this.dispose();
            });
        });

    }

    @Override
    public void components() {
        usuario = new FormComponent("usuario", BorderLayout.WEST, FactoryComponents.get().getTextField());
        usuario.getLabel().setPreferredSize(new Dimension(100, 30));
        password = new FormComponent("contraseña", BorderLayout.WEST, FactoryComponents.get().getPassword());
        password.getLabel().setPreferredSize(new Dimension(100, 30));
        login_button = FactoryComponents.get().getButton("Inicio de sesion");
        config_button = FactoryComponents.get().getButton("...");
        config_button.setPreferredSize(new Dimension(50, 50));
        status_label = FactoryComponents.get().getLabel(status_mgs.formatted(OK));
        status_label.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel padding = new JLabel();
        padding.setPreferredSize(new Dimension(50, 50));

        user_icon.setPreferredSize(new Dimension(width, 200));
        options_panel.setPreferredSize(new Dimension(width, 350));
        options_panel.add(usuario);
        options_panel.add(password);
        options_panel.add(FactoryComponents.get().getLabel(null));
        options_panel.add(login_button);
        sourth_panel.setPreferredSize(new Dimension(width, 50));
        sourth_panel.add(config_button, BorderLayout.WEST);
        sourth_panel.add(status_label, BorderLayout.CENTER);
        sourth_panel.add(padding, BorderLayout.EAST);
        add(user_icon, BorderLayout.NORTH);
        add(options_panel, BorderLayout.CENTER);
        add(sourth_panel, BorderLayout.SOUTH);
    }

    @Override
    public void initialState() {
        JTextField comp1 = (JTextField) usuario.getComponent();
        comp1.setText(null);
        JPasswordField comp2 = (JPasswordField) password.getComponent();
        comp2.setText(null);
    }

    @Override
    public void finalState() {
    }

    private FormComponent password;
    private FormComponent usuario;
    private JButton login_button;
    private JButton config_button;
    private JLabel status_label;
    private final String status_mgs = "Estado: %s",
            OK = "Conectado",
            NOT_OK = "Desconectado";

}
