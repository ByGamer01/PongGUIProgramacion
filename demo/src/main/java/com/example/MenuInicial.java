package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuInicial extends JFrame {
    private JTextField jugador1;
    private JTextField jugador2;
    private JLabel campo;
    private JLabel campo2;
    private JButton confirmar;

    public MenuInicial() {
        setTitle("POOng! - Menú");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        campo = new JLabel("Nom Jugador 1:");
        jugador1 = new JTextField(15); // 15 = ancho en columnas

        campo2 = new JLabel("Nom Jugador 2:");
        jugador2 = new JTextField(15);

        confirmar = new JButton("Començar");

        add(campo);
        add(jugador1);
        add(campo2);
        add(jugador2);
        add(confirmar);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre1 = jugador1.getText();
                String nombre2 = jugador2.getText();

                dispose();

                JFrame frame = new JFrame("POOng!");
                GamePanel panel = new GamePanel(nombre1, nombre2);
                frame.add(panel);
                frame.setSize(1920, 1080);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        
        pack();
        setVisible(true);
    }

}
