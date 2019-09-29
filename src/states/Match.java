/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import game.Display;
import gameObjects.Ball;
import gameObjects.Players;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author rogerio.slucon
 */
public class Match implements State{
    private Players playerOne, playerTwo;
    private Ball ball;
    private static final int INIT_POS = 30;

    public Match() {
        
    }

    @Override
    public void init() {
        this.playerOne = new Players(INIT_POS - 5);
        this.playerTwo = new Players(Display.WIDTH - INIT_POS);
        this.ball = new Ball();

    }

    @Override
    public void update() {
        ball.update();
        playerOne.update();
        playerTwo.update();
        if(playerOne.collision(ball)){
            ball.changeDirection();
        }
        if(playerTwo.collision(ball)){
            ball.changeDirection();
        }


        if(ball.getPosX() < 0){
            playerTwo.toScore();
            ball.reset();
        }else if(ball.getPosX() > Display.WIDTH){
            playerOne.toScore();
            ball.reset();
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Display.WIDTH, Display.HEIGHT);
            
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.PLAIN, 50);
        g.setFont(font);

        g.fillRect(playerOne.getPosX(), playerOne.getPosY(), playerOne.getWidth(), playerOne.getHeight());
        g.fillRect(playerTwo.getPosX(), playerTwo.getPosY(), playerTwo.getWidth(), playerTwo.getHeight());

        g.fillRect(ball.getPosX(), ball.getPosY(), ball.getWidth(), ball.getHeight());

        g.drawString(playerOne.getS(), Display.WIDTH/4, 50);
        g.drawString(playerTwo.getS(), Display.WIDTH/4*3, 50);
    }

    @Override
    public void keyPressed(int code) {
        if(code == 38){
            playerOne.setUp(true);
        }else if(code == 40){
            playerOne.setDown(true);
        }
        if(code == 104){
            playerTwo.setUp(true);
        }else if(code == 98){
            playerTwo.setDown(true);
        }
        if(code == 10){
            ball.reset();
        }

    }

    @Override
    public void keyRelesed(int code) {
        if(code == 38){
            playerOne.setUp(false);
        }else if(code == 40){
            playerOne.setDown(false);
        }
        if(code == 104){
            playerTwo.setUp(false);
        }else if(code == 98){
            playerTwo.setDown(false);
        }
    }

    @Override
    public void keyTyped(int code) {
    }
    
    @Override
    public void dispose(){
        this.dispose();
    }
}
