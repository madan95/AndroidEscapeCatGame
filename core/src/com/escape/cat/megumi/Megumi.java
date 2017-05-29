package com.escape.cat.megumi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Madan on 19/10/2016.
 */

public class Megumi {
    private Vector2 position;
    private float width;
    private float height;
    private Rectangle r;
    private float startx , starty;

    private boolean check = false;
    private int x;

    private boolean firs, second;
    private boolean isAlive = true;

    private int velocity;
    public Megumi(float x, float y, int width, int height){
        position = new Vector2(x, y-10) ;
        this.width = width;
        this.height = height;
        r= new Rectangle(x,y,width,height);
        startx = x;
        starty = y;
        velocity = 2;
    }

    public void update(float delta){
        r.set(getX(),getY(),width,height);
            move();
            }

    public Rectangle getRealRectangle(){
        return r;
    }

    public void onClick(int x, int y, boolean isDown) {

        check = isDown;
        this.x = x;
        }
    public void move() {
        if (isAlive) {
            if (check == true) {
                if (x > Gdx.graphics.getWidth() / 2) {
                    if (r.getX() + getWidth() >= 136) {
                        position.x = 136 - getWidth();
                    } else {
                        position.x += velocity;
                    }
                } else if (x < Gdx.graphics.getWidth() / 2) {
                    if (r.getX() <= 0) {
                        position.x = 0;
                    } else {
                        position.x -= velocity;
                    }
                }
            }
        }
    }
    public boolean isAlive(){
        return isAlive;
    }


    public boolean isSecond() {
        return second;
    }

    public void setSecond(boolean second) {
        this.second = second;
    }

    public boolean isFirs() {
        return firs;
    }

    public void setFirs(boolean firs) {
        this.firs = firs;
    }

    public float getX(){
        return position.x;
    }
    public float getY(){
        return position.y;
    }
    public float getWidth(){
        return width;
    }
    public float getHeight(){
        return height;
    }

    public void stop() {
        isAlive = false;
    }

    public void reset(float delta) {
        isAlive = true;
        position.x = startx;
        position.y = starty-10;
        velocity=2;
        r.set(startx, starty, width, height);

    }

    public void speedUp() {
        velocity = velocity+1;
    }
}
