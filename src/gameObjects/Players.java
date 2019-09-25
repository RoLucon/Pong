/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjects;

import game.Display;

/**
 *
 * @author rogerio.slucon
 */
public class Players extends GameObjects{
    private int score = 0;

    public Players() {
        width = 20;
        height = 100;
        speed = 10;
    }
    
    public Players(int posX) {
        width = 20;
        height = 100;
        speed = 10;
        this.posX = posX - width/2;
        posY = Display.HEIGHT/2 - height;
    }
    
    public void up(){
        if(posY > 30){
            posY -= speed;
        }
    }
    
    public void down(){
        if(posY < Display.HEIGHT - 50 - height){
            posY += speed;
        }
    }
    
    public void score(){
        score++;
    }

    public int getScore() {
        return score;
    }
    
    public String getS() {
        return Integer.toString(score);
    }
    
    public void setScore(int score) {
        this.score = score;
    }

}
