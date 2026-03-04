package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

// Classe que representa un panell on es dibuixa un cercle que rebota
public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private int x = 50, y = 50; // Coordenades inicials del cercle
    private int dx = 2, dy = 2; // Velocitat del moviment en X i Y
    private final int RADI = 20; // Radi del cercle
    private final int DELAY = 10; // Retard del temporitzador en mil·lisegons
    private Timer timer; // Temporitzador per controlar l'animació
    private Jugador jugador1; // Juagdor Izquierda
    private Jugador jugador2; // Jugador Derecho
    private static final int HEIGHT = 100;
    private static final int WIDTH = 50;
    private int score1 = 0; // Puntuacion del jugador 1
    private int score2 = 0; // puntuacion del jugador 2


    // Variables de Los jugadores (de sus paletas o palas)
    private int jx1 = 25;
    private int jy1 = 50;
    private int jx2 = 1450;
    private int jy2 = 50;

    // Constructor que inicialitza el panell i inicia el temporitzador
    public GamePanel() {
        setBackground(Color.WHITE); // Defineix el color de fons del panell
        timer = new Timer(DELAY, this); // Crea el temporitzador amb retard especificat
        timer.start(); // Inicia el temporitzador
        // y = altura ; x = ancho
        //                 x     y
        // frame.setSize(1920, 1080); // Defineix la mida de la finestra
        // El frame mide todo eso, por lo que a la hora de distribuir las posiciones iniciales de los jugadores, 
        // tenemos que tenerlas en cuenta
        jugador1 = new Jugador(jy1, jx1);
        jugador2 = new Jugador(jy2, jx2); // Para mi pantalla, se ve perfecto asi.
        setFocusable(true);
        addKeyListener(this);
    }

    // Mètode per dibuixar el cercle dins del panell
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Conversió a Graphics2D per millorar el dibuix
        g2d.setColor(Color.RED); // Defineix el color del cercle
        g2d.fillOval(x, y, RADI * 2, RADI * 2); // Dibuixa el cercle amb les coordenades i el radi

        g2d.fillRect(jx1, jy1, WIDTH, HEIGHT); // Paleta del jugador 1 c

        g2d.fillRect(jx2, jy2, WIDTH, HEIGHT);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                jy1 -= 15;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                jy1 += 15;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                jy2 -= 15;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                jy2 += 15;
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                score1 = 0;
                score2 = 0;
            }
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent event) {

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
            JFrame frame = new JFrame("Game Panel"); // Crea la finestra
            GamePanel panel = new GamePanel(); // Crea una instància del panell
            frame.add(panel); // Afegeix el panell a la finestra

            frame.setSize(1920, 1080); // Defineix la mida de la finestra
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura el tancament de la finestra
            frame.setLocationRelativeTo(null); // Centra la finestra a la pantalla
            frame.setVisible(true); // Mostra la finestra
        });
    }

}

/* 
Estructura de Carpetas: 27/02 - Diario de Abordo

· Assets:

../assets/background -> Imagenes de fondo, para personalizarlo mas
../assets/choose-game -> en realidad este podria estar ubicado dentro de la carpeta de background, 
existe para que en el selector de fondo, cada imagen te salga; aunque en realidad no la necesito
../assets/icon -> para el icono, no me gusta el de Java. A mi me gusta currarmelo.

· Src (es como 'lib'):
../src/
../src/main/java/com/example/GamePanel.java -> Panel principal del juego, donde los jugadores se enfrentan al 1 vs 1
../src/main/java/com/example/Jugador.java -> Clase Jugador y/o Paleta
../src/main/java/com/example/Pong.java -> Clase Principal para ejecutar el codigo (de momento)

o ../../../../../../GamePanel.java 
No estoy seguro, no suelo tener tantas carpetas a la hora de trabajar. En Dart lo optimizo mejor

../pom.xml -> Para dependencias, e info del proyecto
*/
