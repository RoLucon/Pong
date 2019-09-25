package gameObjects;

import game.Display;
import states.Match;

import java.util.Random;

public class Ball extends GameObjects {
    private int angulo;

    public Ball() {
        width = height = 10;
        speed = 10;
       reset();
    }

    public void update(){
        if (posY < 30){
            changeDirection();
        }else if(posY > Display.HEIGHT - 60){
            changeDirection();
        }
        posY += (int) (Math.sin(Math.toRadians(angulo))* speed);
        posX += (int) (Math.cos(Math.toRadians(angulo))* speed);
    }
    //Ajustar Alteracao de angulos
    public void changeDirection(){
        angulo += 180;
        if(angulo > 360){
            angulo -= 360;
        }
    }

    public void reset(){
        posX = Display.WIDTH/2 - width/2;
        posY = Display.HEIGHT/2 - height/2;
        angulo = new Random().nextInt(360);
    }

}
