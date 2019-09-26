package gameObjects;

import game.Display;
import sound.SoundManager;
import states.Match;

import java.util.Random;

public class Ball extends GameObjects {
    private float angulo;

    public Ball() {
        width = height = 10;
        speed = 10;
       reset();
       angulo = 90;
    }

    public void update(){
        if (posY < 30){
            posY = 30;
            changeDirection2();
        }else if(posY > Display.HEIGHT - 60){
            posY =  Display.HEIGHT - 60;
            changeDirection2();
        }
        posX -= (int) (Math.cos(Math.toRadians(angulo))* speed);
        posY -= (int) (Math.sin(Math.toRadians(angulo))* speed);
    }

    //Ajustar Alteracao de angulos Para metodo unico
    public void changeDirection() {
        SoundManager.playCollision();
        angulo = 180 - angulo;
        if (angulo > 360) {
            angulo -= 360;
        }
        if (angulo < 0) {
            angulo += 360;
        }
    }

    public void changeDirection2() {
        SoundManager.playCollision();
        if (angulo >= Math.PI) {
            angulo = (float) (4 * Math.PI - angulo);
        }
        // down-left case
        else {
            angulo = (float) (2 * Math.PI - angulo);
        }
    }

    public void reset(){
        posX = Display.WIDTH/2 - width/2;
        posY = Display.HEIGHT/2 - height/2;
        angulo = new Random().nextInt(360);
    }
}
