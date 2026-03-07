package com.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

// Classe que representa un panell on es dibuixa un cercle que rebota
public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private int x = 50, y = 50; // Coordenades inicials del cercle
    private int dx = 4, dy = 4; // Velocitat del moviment en X i Y // Velocidad a 4 para mas velocidad
    private final int RADI = 20; // Radi del cercle
    private final int DELAY = 10; // Retard del temporitzador en mil·lisegons
    private Timer timer; // Temporitzador per controlar l'animació
    private Jugador jugador1; // Juagdor Izquierda
    private Jugador jugador2; // Jugador Derecho
    private int score1 = 0; // Puntuacion del jugador 1
    private int score2 = 0; // puntuacion del jugador 2
    private String nombre1; // jugador1
    private String nombre2; // jugador2
    private BufferedImage fondo; // para poner una imagen en el fondo personalizada jejeje vi un par de videos

    // Constructor que inicialitza el panell i inicia el temporitzador
    public GamePanel(String nombre1, String nombre2) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        setBackground(Color.WHITE); // Defineix el color de fons del panell
        timer = new Timer(DELAY, this); // Crea el temporitzador amb retard especificat
        timer.start(); // Inicia el temporitzador
        // y = altura ; x = ancho
        // x y
        // frame.setSize(1920, 1080); // Defineix la mida de la finestra
        // El frame mide todo eso, por lo que a la hora de distribuir las posiciones
        // iniciales de los jugadores,
        // tenemos que tenerlas en cuenta
        // La clase jugador ya tiene todo lo necesario jeje
        jugador1 = new Jugador(25, 50, 50, 100, 15);
        jugador2 = new Jugador(1450, 50, 50, 100, 15);
        try {
            fondo = ImageIO.read(new File("demo/assets/background/fondo.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setFocusable(true);
        addKeyListener(this);
    }

    // Mètode per dibuixar el cercle dins del panell
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g; // Conversió a Graphics2D per millorar el dibuix

        if (fondo != null) { // fondo (imagen)
            g2d.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
        } else {
            super.paintComponent(g);
        }
        g2d.setColor(Color.RED); // Defineix el color del cercle
        g2d.fillOval(x, y, RADI * 2, RADI * 2); // Dibuixa el cercle amb les coordenades i el radi

        jugador2.setX(getWidth() - jugador2.getWidth() - 25); // Para evitar un bug donde la bola se comia la mitad de
                                                              // la pala antes de rebotar

        jugador1.draw(g2d); // Este es nuestro metodo draw que hay dentro de la clase Jugador
        jugador2.draw(g2d);

        // Marcador de la pUntuacion
        // Dividimos la pantalla en 4, dos para el jugador 1 y dos para el jugador2
        g2d.setFont(new Font("Arial", Font.BOLD, 30)); // ponemos una fuente, y buen tamaño para que se vea la puntuacion
        g2d.setColor(Color.WHITE);
        g2d.drawString(nombre1 + score1, getWidth() / 4, 30);
        g2d.drawString(nombre2 + score2, 3 * getWidth() / 4, 30);
    }

    // Utilizamos los metodos especificos que tenemos en nuestra clase jugador, asi
    // los tenemos mas ordenados
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                jugador1.moveUp(0);
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                jugador1.moveDown(getHeight());
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                jugador2.moveUp(0);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                jugador2.moveDown(getHeight());
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
    // Este es el metodo para las colisiones
    @Override
    public void actionPerformed(ActionEvent e) {

        // Rebote vertical (techo y suelo)
        if (y + 2 * RADI >= getHeight() || y <= 0) {
            dy = -dy;
        }

        // Colisión con pala IZQUIERDA (las 3 condiciones JUNTAS)
        if (x <= jugador1.getX() + jugador1.getWidth()
                && y + 2 * RADI >= jugador1.getY()
                && y <= jugador1.getY() + jugador1.getHeight()) {
            dx = -dx; // Rebota

            // Gol del jugador2 (porteria de la izquierda y paleta del jugador1)
        } else if (x <= 0) { // Bug antes; Imagina que la pelota pasa la pala izquierda y llega a x = -5
            // Se ejecutaban las dos cosas a la vez. La pelota rebota y marca gol al mismo
            // tiempo.
            // Necesitas que sean excluyentes: si es gol, no hay colisión.
            score2++;
            x = getWidth() / 2;// PAra que la bola aparezca en el centro del campo
            y = getHeight() / 2;// Es decir, para que se reinicien las coordenadas del nuevo frame
        }

        // Colisión con pala DERECHA
        if (x + 2 * RADI >= jugador2.getX() // pelota llega a la pala horizontalmente
                && y + 2 * RADI >= jugador2.getY() // pelota no está por ENCIMA de la pala
                && y <= jugador2.getY() + jugador2.getHeight()) // pelota no está por DEBAJO de la pala
        {
            dx = -dx;

            // Gol del Jugador1 (porteria derecha y pala del jugador2)
        } else if (x + 2 * RADI >= getWidth()) { // Si no ponia el else if, habia un tremendo bug
            score1++;
            x = getWidth() / 2;
            y = getHeight() / 2;
        }

        /*
         * El lado derecho de la pelota ha llegado al lado izquierdo de la pala
         * -> hay contacto horizontal (primera condicion)
         * 
         * La parte inferior de la pelota está por debajo del borde superior de la pala
         * -> la pelota no está completamente por encima (segunda condicion)
         * 
         * La parte superior de la pelota está por encima del borde inferior de la pala
         * -> la pelota no está completamente por debajo (tercera condicion)
         * 
         * 
         * La pelota no "se mueve" realmente. Cada frame se borra todo (eso hace
         * super.paintComponent(g)) y se vuelve a dibujar en la nueva posición. Es como
         * un flipbook: cada página es un dibujo nuevo.
         * 
         * el lado derecho de la pelota es x + 2 * RADI
         * y el borde derecho del panel es getWidth()
         * 
         */

        x += dx;
        y += dy;

        repaint();

    }

}

/*
 * Estructura de Carpetas: 27/02 - Diario de Abordo
 * 
 * · Assets:
 * 
 * ../assets/background -> Imagenes de fondo, para personalizarlo mas
 * ../assets/choose-game -> en realidad este podria estar ubicado dentro de la
 * carpeta de background,
 * existe para que en el selector de fondo, cada imagen te salga; aunque en
 * realidad no la necesito
 * ../assets/icon -> para el icono, no me gusta el de Java. A mi me gusta
 * currarmelo.
 * 
 * · Src (es como 'lib'):
 * ../src/
 * ../src/main/java/com/example/GamePanel.java -> Panel principal del juego,
 * donde los jugadores se enfrentan al 1 vs 1
 * ../src/main/java/com/example/Jugador.java -> Clase Jugador y/o Paleta
 * ../src/main/java/com/example/Pong.java -> Clase Principal para ejecutar el
 * codigo (de momento)
 * 
 * o ../../../../../../GamePanel.java
 * No estoy seguro, no suelo tener tantas carpetas a la hora de trabajar. En
 * Dart lo optimizo mejor
 * 
 * ../pom.xml -> Para dependencias, e info del proyecto
 */
