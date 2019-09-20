/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author rogerio.slucon
 */
public class Display extends JFrame{
    public static final int WIDTH = 600;
    public static final int HEIGHT = (WIDTH * 9 /10);
    
    private Canvas canvas;
    
    public Display() throws HeadlessException {      
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        setTitle("Game");
        add(canvas);
        pack();
        canvas.setFocusable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    public BufferStrategy getBufferStrategy(){
        return canvas.getBufferStrategy();
    }
    
    public void createBufferStraregy(){
        canvas.createBufferStrategy(3);
    }
    
    public void setKeyListener(KeyListener l){
        addKeyListener(l);
    }
}
