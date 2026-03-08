package com.example;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
    private JButton botonIA; // es el modo de un jugador jeje

    public MenuInicial() {
        setTitle("POOng! - Menú");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        // Imagen personalizada de fondo para el PONG
        ImageIcon gifIcon = new ImageIcon("demo/assets/background/pongTitulo.gif");
        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setAlignmentX(CENTER_ALIGNMENT);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // para que todo quede en el centro en forma de
                                                                      // arbol
        Font fuenteMenu = new Font("Arial", Font.BOLD, 18); // Fuente para todo el texto del menu
        campo = new JLabel("Nom Jugador 1:");
        campo.setFont(fuenteMenu);
        jugador1 = new JTextField(15); // 15 = ancho en columnas

        campo2 = new JLabel("Nom Jugador 2:");
        campo2.setFont(fuenteMenu); // les añadimos el tipo de fuente
        jugador2 = new JTextField(15);

        jugador1.setMaximumSize(new java.awt.Dimension(200, 30)); // les ponemos un tamaño maximo de dimension
        jugador2.setMaximumSize(new java.awt.Dimension(200, 30));

        jugador1.setBackground(Color.DARK_GRAY); // colores bonitos jeje
        jugador1.setForeground(Color.WHITE);
        jugador1.setCaretColor(Color.WHITE); // cursor blanco
        jugador2.setBackground(Color.DARK_GRAY);
        jugador2.setForeground(Color.WHITE);
        jugador2.setCaretColor(Color.WHITE);

        confirmar = new JButton("Començar"); // boton de començar
        instrucciones = new JButton("Instruccions"); // boton de instrucciones

        confirmar.setFont(fuenteMenu); // les aplicamos la misma fuente
        instrucciones.setFont(fuenteMenu);

        confirmar.setFocusPainted(false); // quitamos el borde azul al pulsar
        instrucciones.setFocusPainted(false);

        campo.setForeground(Color.WHITE); // les ponemos blancos para que se note que esto no es un pong cualquiera
        campo2.setForeground(Color.WHITE);
        confirmar.setBackground(Color.WHITE);

        campo.setAlignmentX(CENTER_ALIGNMENT); // los alineamos en el centro
        jugador1.setAlignmentX(CENTER_ALIGNMENT);
        campo2.setAlignmentX(CENTER_ALIGNMENT);
        jugador2.setAlignmentX(CENTER_ALIGNMENT);
        confirmar.setAlignmentX(CENTER_ALIGNMENT);
        instrucciones.setAlignmentX(CENTER_ALIGNMENT);

        add(gifLabel); // Estan por orden
        add(Box.createVerticalStrut(20)); // espacio de 20px ; si lo se, esto lo pude haber hecho mas sencillo pero el quick fixme los puso asi :D
        add(campo);
        add(Box.createVerticalStrut(20)); // espacio de 20px
        add(jugador1);
        add(Box.createVerticalStrut(20)); // espacio de 20px
        add(campo2);
        add(Box.createVerticalStrut(20)); // espacio de 20px
        add(jugador2);
        add(Box.createVerticalStrut(20)); // espacio de 20px
        add(confirmar);
        add(Box.createVerticalStrut(20)); // espacio de 20px
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

        setVisible(true);
    }

}
