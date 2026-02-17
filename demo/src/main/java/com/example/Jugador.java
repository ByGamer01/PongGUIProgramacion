package com.example;

import java.awt.Color;

import javax.swing.JFrame;

public class Jugador extends JFrame {
    public int y;
    public int x;
    
   
    public Jugador(int y, int x) {
        this.y = y;
        this.x = x;

        this.setBackground(Color.BLACK);        
    }
}