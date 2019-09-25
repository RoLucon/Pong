package gameObjects;

import game.Display;
import states.Match;

public class Ball extends GameObjects {
    private int angulo = 90;

    public Ball() {
        width = height = 10;
        speed = 10;
        posX = Display.WIDTH/2 - width/2;
        posY = Display.HEIGHT/2 - height/2;
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

    public void changeDirection(){
        angulo += 180;
        if(angulo > 360){
            angulo -= 360;
        }
    }

}
