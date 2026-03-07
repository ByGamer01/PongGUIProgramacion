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

    public void moveUp(int limiteArriba) { // Limite para que la pala no pueda superar el limite impuesto que sera 0 
        y -= velocidad;
        if (y < limiteArriba) {
            y = limiteArriba;
        }
    }

    public void moveDown(int limiteAbajo) { // Limite para que la pala no pueda superar el limite que impongamos abajo
                                            // que sera el getHeight()
        y += velocidad; // mueve como estaba puesto antes
        if (y + height > limiteAbajo) {
            // Condicion para que no pueda sobreposar el limite; si la altura de la pala es
            // superior al limite de abajo entonces la y resta al limiteAbajo la altura
            y = limiteAbajo - height;
        }
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