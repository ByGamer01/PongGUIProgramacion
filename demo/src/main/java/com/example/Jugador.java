package com.example;
// El objetivo es que la clase jugador sea una clase que siga los parametros o indicaciones, o como se llame, de la POO.

// Entonces debe de resolver un error, y ser una caja cerrada, y no como la tenia antes. 

import java.awt.Graphics2D;

public class Jugador {
    private int x, y;
    private int width, height;
    private int velocidad;

    public Jugador(int x, int y, int width, int height, int velocidad) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocidad = velocidad;
    }

    // Si y aumenta, bajas. Si y disminuye, subes (Lo habia hecho al reves)

    public void moveUp() { // Siempre es la Y la que se mueve de arriba a abajo, ya que es la altura
        // ¿cómo se mueve hacia arriba?
        y = y - velocidad;
    }

    public void moveDown() {
        // ¿cómo se mueve hacia abajo?
        y = y + velocidad;

    }

    public void draw(Graphics2D g) {
        g.fillRect(x, y, width, height); // Paleta del jugador 1 c
    }

    // Getters:

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getHeight() {
        return this.height;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public int getWidth() {
        return this.width;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }
}