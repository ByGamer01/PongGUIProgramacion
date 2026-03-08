package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Instrucciones extends JFrame {
    private JTextArea instrucciones;
    private JButton boton;

    public Instrucciones() {
        setTitle("Intrucciones del POOng - David Gil");
        setSize(400, 300); // poquito tamaño
        setLayout(new FlowLayout()); // flowlayout que me gusta jaja
        // las instrucciones de toda la vida solo que en catalan
        setLocationRelativeTo(null);
        instrucciones = new JTextArea("Controles:\n" + "Jugador 1: W (amunt) / S (avall)\n"
                + "Jugador 2: ↑ (amunt) / ↓ (avall)\n" + "Si la pilota surt per l'esquerra, punt per al Jugador 2.\n"
                + "Si la pilota surt per la dreta, punt per al Jugador 1." + "\n\n Presiona ESC si vols pausar el lloc" + "\n Bona Sort! :D ~ David Gil");
        boton = new JButton("Tancar");

        add(instrucciones);
        add(boton);
        boton.addActionListener(new ActionListener() { // Añadimos la funcionalidad del boton para que funcione
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
