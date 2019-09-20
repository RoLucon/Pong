/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import game.Display;
import game.Players;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author rogerio.slucon
 */
public class Match implements State{
    private Players playerOne, playerTwo;

    public Match() {
        
    }
    
    
    @Override
    public void init() {
        this.playerOne = new Players();
        this.playerTwo = new Players();
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Display.WIDTH, Display.HEIGHT);
            
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.PLAIN, 50);
        g.setFont(font);
        
        g.drawString(playerOne.getS(), Display.WIDTH/4, 50);
        g.drawString(playerTwo.getS(), Display.WIDTH/4*3, 50);
    }

    @Override
    public void keyPressed(int code) {
    }

    @Override
    public void keyRelesed(int code) {
    }

    @Override
    public void keyTyped(int code) {
    }
    
    @Override
    public void dispose(){
     this.dispose();
    }
    
}
