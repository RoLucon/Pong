/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjects;

import game.Display;
import sound.SoundManager;

/**
 *
 * @author rogerio.slucon
 */
public class Players extends GameObjects{
    private int score = 0;
    private int velocity = 0;
    private boolean up = false, down = false;

    @Override
    public void update() {
        if(velocity > 0){
            velocity --;
        }else if(velocity < 0){
            velocity++;
        }

        if(up){
            velocity += 2;
        }else if(down){
            velocity -= 2;
        }
        if(velocity != 0){
            if(posY >= 30 && posY <= Display.HEIGHT - 50 - height) {
                posY -= velocity;
            }
        }
        if(posY < 30){
            posY = 30;
        }else if(posY > Display.HEIGHT - 50 - height){
            posY = Display.HEIGHT - 50 - height;
        }

    }

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
        velocity += 2;
    }
    
    public void down(){
        velocity -= 2;
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

    public void toScore() {
        SoundManager.playScore();
        score++;
    }
    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
