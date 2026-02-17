package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

// Classe que representa un panell on es dibuixa un cercle que rebota
public class CercleRebotant extends JPanel implements ActionListener {

    private final boolean raised = false;
    private int x = 50, y = 50; // Coordenades inicials del cercle
    private int dx = 2, dy = 2; // Velocitat del moviment en X i Y
    private final int RADI = 20; // Radi del cercle
    private final int DELAY = 10; // Retard del temporitzador en mil·lisegons
    private Timer timer; // Temporitzador per controlar l'animació
    private Jugador jugador1; // Juagdor Izquierda
    private Jugador jugador2; // Jugador Derecho
    private static final int HEIGHT = 100;
    private static final int WIDTH = 50;


    // Constructor que inicialitza el panell i inicia el temporitzador
    public CercleRebotant() {
        setBackground(Color.WHITE); // Defineix el color de fons del panell
        timer = new Timer(DELAY, this); // Crea el temporitzador amb retard especificat
        timer.start(); // Inicia el temporitzador

        jugador1 = new Jugador(100, 50);
        jugador2 = new Jugador(100, 100);
    }

    // Mètode per dibuixar el cercle dins del panell
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Conversió a Graphics2D per millorar el dibuix
        g2d.setColor(Color.RED); // Defineix el color del cercle
        g2d.fillOval(x, y, RADI * 2, RADI * 2); // Dibuixa el cercle amb les coordenades i el radi


        g2d.fillRect(jugador1.x, jugador1.y, WIDTH, HEIGHT); // Paleta del jugador 1 c

        g2d.fillRect(jugador2.x, jugador2.y, WIDTH, HEIGHT);

    }

    // Mètode que s'executa a cada tic del temporitzador per moure el cercle
    @Override
    public void actionPerformed(ActionEvent e) {

        // Comprova si el cercle toca les vores horitzontals
        if (x + 2 * RADI >= getWidth() || x <= 0) {
            dx = -dx; // Inverteix la direcció horitzontal
        }

        // Comprova si el cercle toca les vores verticals
        if (y + 2 * RADI >= getHeight() || y <= 0) {
            dy = -dy; // Inverteix la direcció vertical
        }

        // Actualitza la posició del cercle
        x += dx;
        y += dy;

        repaint(); // Redibuixa el panell per actualitzar la posició del cercle
    }
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cercle Rebotant"); // Crea la finestra
            CercleRebotant panel = new CercleRebotant(); // Crea una instància del panell
            frame.add(panel); // Afegeix el panell a la finestra

            frame.setSize(1920, 1080); // Defineix la mida de la finestra
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura el tancament de la finestra
            frame.setLocationRelativeTo(null); // Centra la finestra a la pantalla
            frame.setVisible(true); // Mostra la finestra
        });
    }

}
