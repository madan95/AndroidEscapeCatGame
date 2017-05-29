package com.escape.cat.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.escape.cat.megumi.Megumi;

import java.util.Random;

/**
 * Created by Madan on 20/10/2016.
 */

public class Bar {

    private Vector2 position, velocity;
    private int width, height;
    private boolean isScrolled;
    private boolean scored = false;
    private float speed;
    private Random r;
    private Rectangle barr;

    public Bar(float x, float y, int width, int height, float speed) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, speed);
        this.width = width;
        this.height = height;
        isScrolled = false;
        this.speed = speed;
        r = new Random();
        barr = new Rectangle();

    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
        if (position.y > (Gdx.graphics.getHeight() / (Gdx.graphics.getWidth() / 136))) {
            isScrolled = true;
        }
        barr.set(position.x, position.y, width, height);
    }

    public Rectangle getBarr() {
        return barr;
    }

    public boolean isScrolled() {
        return isScrolled;
    }

    public float getTailY() {
        return (int) (position.y);
    }

    public void setPositionX(float x) {
        position.x = x;
    }

    public float getPositionX() {
        return position.x;
    }

    public void setScrolled(boolean b) {
        isScrolled = b;
    }

    public void reset(float v) {
        position.y = v;
        scored = false;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean b) {
        scored = b;
    }

    public boolean collides(Megumi megumi) {
        if (position.y + height > megumi.getY()) {
            return (Intersector.overlaps(megumi.getRealRectangle(), barr));
        }
        return false;
    }

    public void stop() {
        velocity.y = 0;
    }

    public void resets(int i, int i1, int i2, int i3, int speed, float delta) {
        position.x = i;
        position.y = i1;
        barr.set(i, i1, i2, i3);
        isScrolled = false;
        scored = false;
        velocity.y = this.speed;
        //      position.add(velocity.cpy().scl(delta));
    }

    public void setSpeed() {
        velocity.y = velocity.y +1;
    }

    public float getSpeed() {
        return velocity.y;
    }
}
