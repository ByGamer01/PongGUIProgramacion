package com.example;

import java.awt.Color;
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
    private JButton instrucciones;

    public MenuInicial() {
        setTitle("POOng! - Menú");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        // Imagen personalizada de fondo para el PONG
        ImageIcon gifFondo = new ImageIcon("assets/POONG-ARCADE-3-8-2026.gif");
        JLabel fondo = new JLabel(gifFondo);
        fondo.setLayout(new FlowLayout());
        setContentPane(fondo); // El fondo reemplaza el contenido del frame

        setLayout(new FlowLayout());

        campo = new JLabel("Nom Jugador 1:");
        jugador1 = new JTextField(15); // 15 = ancho en columnas

        campo2 = new JLabel("Nom Jugador 2:");
        jugador2 = new JTextField(15);

        confirmar = new JButton("Començar"); // boton de començar
        instrucciones = new JButton("Instruccions"); // boton de instrucciones
        campo.setForeground(Color.WHITE); // les ponemos blancos para que se note que esto no es un pong cualquiera
        campo2.setForeground(Color.WHITE);
        confirmar.setBackground(Color.WHITE);
        add(campo);
        add(jugador1);
        add(campo2);
        add(jugador2);
        add(confirmar);
        add(instrucciones);

        instrucciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Instrucciones();
            }
        });

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre1 = jugador1.getText(); // guardamos los parametros que ponen los usuarios en variables
                                                     // para luego ponerlas en los marcadores
                String nombre2 = jugador2.getText();

                dispose(); // dispose() libera los recursos de la ventana y la cierra.

                JFrame frame = new JFrame("POOng! - David Gil");
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
