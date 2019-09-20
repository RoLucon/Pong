/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Rogerio
 */
public class GameStateManager implements KeyListener{
    public static final int NUMBER_STATES = 1;
    public static State[] states = new State[NUMBER_STATES];
    public static int currentState = 0;
    
    public static void setState(int state){
        states[state].init();
        currentState = state;
        
    }
    
    public static void nextState(){
        currentState++;
        states[currentState].init();
    }
    
    public GameStateManager() {
        states[0] = new Menu();
    }
    
    public void update(){
        states[currentState].update();
    }
    
    public void render(Graphics g){
        states[currentState].render(g);
    }
    
    public State isState(){
        return states[currentState];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        states[currentState].keyTyped(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        states[currentState].keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        states[currentState].keyRelesed(e.getKeyCode());
    }
    
}
