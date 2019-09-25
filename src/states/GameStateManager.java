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
    public enum States{Menu, Match};
    public static final int NUMBER_STATES = 2;
    public static State[] states = new State[NUMBER_STATES];
    public static int currentState = 0;
    
    public static void setState(States state){
        changeState(state);
        if(currentState == 0){
            states[1].init();
            currentState = 1;
            states[0].dispose();
        }else{
            states[0].init();
            currentState = 0;
            states[1].dispose();
        }

    }

    private static void changeState(States state){
        int aux;
        if(currentState == 0){
            aux = 1;
        }else{
            aux= 0;
        }
        switch(state){
            case Match:
                states[aux] = new Match();
        }
    }
    
    public GameStateManager() {
        states[0] = new Menu();
        states[1] = new Match();
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
