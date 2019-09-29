package gameObjects;

import java.sql.Time;

public abstract class GameObjects {
    protected int posX, posY;
    protected int width, height;
    protected int speed;
    private int pivot;
    private  float collisionTime = 0.5f;
    private long previusTime;
    private boolean collision = true;

    public abstract void update();

    public int[] getPivot(){
        return new int[] {(posX -width), (posY - height)};
    }

    public boolean collision(GameObjects go){
        boolean flag = false;
        if(collision){
            if(go.posX < this.posX + this.width && go.posX  + go.width > this.posX){
                if(go.posY  + go.height > this.posY && go.posY  < this.posY + height) {
                    flag = true;
                    collision = false;
                    previusTime = System.currentTimeMillis();
                }
            }
        }else{
            if((System.currentTimeMillis() - previusTime) / 1000 > collisionTime){
                collision = true;
            }
        }
        return flag;
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
        posY = posY;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCollisionTime(int collisionTime) {
        this.collisionTime = collisionTime;
    }
}
