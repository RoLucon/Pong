/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author rogerio.slucon
 */
public class Players {
    private int score = 0;
    private int posX, posY;
    private int width, height;

    public Players() {
    }
    
    public Players(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public void up(){
        if(posY < 30){
            posY--;
        }
    }
    
    public void down(){
        if(posY < Display.HEIGHT - 30){
            posY++;
        }
    }
    
    public void score(){
        score++;
    }

    public int getScore() {
        return score;
    }
    
    public String getS() {
        return Integer.toOctalString(score);
    }
    
    public void setScore(int score) {
        this.score = score;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
