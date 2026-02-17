package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Pong extends JFrame implements ActionListener, KeyListener {
    private CercleRebotant panel; // Pelota

    public Pong() {
        setSize(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setTitle("Pong - Java Swing | David Gil");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] args) {
        new Pong();
    }
}
/*
 * En primer lugar, pensé en hacer uso del LayeredPane, pero no se puede volver
 * transparente su fondo, ademas de que son muchos paneles a diferentes capas
 * por lo que pasé a buscar sobre alguna manera de integrar un Canvas/Canva
 * (sistema de capas, como hay cuando diseñas graficamente),
 * y me apareció el Canvas de AWT. Hablé con Claude Opus 4.6 sobre la idea de
 * hacer funcionar esta idea, sin codigo de por medio, solamente teorico,
 * para aprender yo y poder utilizarlo mas adelante; Es verdad que este es el
 * siguiente paso si haces uso del paintComponent que utiliza Java Swing
 * para este tipo de programas, pero queria hacer algo que el resto de mi clase
 * no hubiera hecho y sobresalir (como siempre ha ocurrido, es el caso de mi
 * aplicación
 * de fitness que combina el anime con los videojuegos, llamada FitVerso, de
 * momento solo esta para Android, pero dentro de poco estará para IOS).
 * 
 * 
 * Pero es una pena, el enunciado del ejercicio pide explicitamente Java Swing, y Graphics2D de clase usada, por lo que tendria que usar paintComponent principalmente
 * Si fuera con Canvas de AWT, seria exclusivamente con AWT, Swing no tiene un ecosistema sostenible con AWT en el tema de los renderizados.
 */