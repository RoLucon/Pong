/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import states.GameStateManager;

/**
 *
 * @author rogerio.slucon
 */
public class Game implements Runnable{
    
    boolean gameOn = false;
    int FPS = 60;
    double TIME_P_TICK = 1000000000 / FPS;
            
    private Display displey;
    private Thread thread;
    
    private GameStateManager gSM;
    
    public Game() {
        displey = new Display();
        gSM = new GameStateManager();
        displey.setKeyListener(gSM);
    } 

    @Override
    public void run() {
        init();
        double dT = 0;
        long now;
        long lastTime = System.nanoTime();
        
        while(gameOn){
            now = System.nanoTime();
            dT += (now - lastTime) / TIME_P_TICK;
            lastTime = now;
            
            if(dT >= 1){
                update();
                render();
                dT = 0;
            }
        }
    }
    
    public synchronized void start(){
        if(thread != null){
            return;
        }
        thread = new Thread(this);
        thread.start();
        gameOn = true;
    }
    
    public synchronized void stop(){
        if(thread == null){
            return;
        }
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void init(){
    
    }
    
    private void update(){
        if(gSM != null){
            gSM.update();
        }
    }
    
    private void render(){    
        BufferStrategy bs = displey.getBufferStrategy();
        if(bs == null){
            displey.createBufferStraregy();
            bs = displey.getBufferStrategy();
        }
        Graphics g = bs.getDrawGraphics();
        if(gSM != null){
            gSM.render(g);
        }
        
        g.dispose();
        bs.show();
    }
    
    public static void main(String[] args) {   
        Game game = new Game();
        game.start();
    }
    
}
