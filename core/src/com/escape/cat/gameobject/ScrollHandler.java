package com.escape.cat.gameobject;

import com.badlogic.gdx.Gdx;
import com.escape.cat.gameworld.GameWorld;
import com.escape.cat.megumi.Megumi;


import java.util.Random;

/**
 * Created by Madan on 20/10/2016.
 */

public class ScrollHandler {
    private Bar bar1, bar2, bar3;
    private GameWorld gameWorld;
    private Random r;
    public static final int SPEED = 59;
    public static final int GAP = 90 ;

    public ScrollHandler(GameWorld gameWorld){

        this.gameWorld=gameWorld;
        r = new Random();
        bar1 = new Bar(r.nextInt(50)+0,0, 90,22,SPEED);
        bar2 = new Bar(r.nextInt(50)+0,bar1.getTailY()-GAP,90,22,SPEED);
        bar3 = new Bar(r.nextInt(50)+0, bar2.getTailY()-GAP, 90, 22, SPEED);

    }

    public void update(float delta){
        bar1.update(delta);
        bar2.update(delta);
        bar3.update(delta);

        if(bar1.isScrolled()){
            bar1.reset(bar3.getTailY()-GAP);
                if(bar3.getPositionX()>=23) {
                    bar1.setPositionX(r.nextInt(23)+0);
                } else if(bar3.getPositionX()<=(23)){
                    bar1.setPositionX(r.nextInt(47)+22);
                }
            bar1.setScrolled(false);

        }else if(bar2.isScrolled()){
            bar2.reset(bar1.getTailY()-GAP);
            if(bar1.getPositionX()>=(23)) {
                bar2.setPositionX(r.nextInt(23)+0);
            } else if(bar1.getPositionX()<=(23)){
                bar2.setPositionX(r.nextInt(47)+22);
            }
            bar2.setScrolled(false);

        }else if(bar3.isScrolled()){
            bar3.reset(bar2.getTailY()-GAP);
            if(bar2.getPositionX()>=(23)) {
                bar3.setPositionX(r.nextInt(23)+0);
            } else if(bar2.getPositionX()<=(23)){
                bar3.setPositionX(r.nextInt(47)+22);
            }
            bar3.setScrolled(false);

        }
    }


    public Bar getBar1() {
        return bar1;
    }

    public Bar getBar2() {
        return bar2;
    }

    public Bar getBar3() {
        return bar3;
    }

    public void addScore(int adder){
        gameWorld.addScore(adder);
    }
    public void stop() {
        bar1.stop();
        bar2.stop();
        bar3.stop();
    }

    public boolean collides(Megumi megumi) {
        if(!bar1.isScored() && bar1.getTailY() > megumi.getY()+megumi.getHeight()){
            addScore(1);
            bar1.setScored(true);
        } else   if(!bar2.isScored() && bar2.getTailY() > megumi.getY()+megumi.getHeight()){
            addScore(1);
            bar2.setScored(true);
        } else   if(!bar3.isScored() && bar3.getTailY() > megumi.getY()+megumi.getHeight()){
            addScore(1);
            bar3.setScored(true);
        }
        return(bar1.collides(megumi)||bar2.collides(megumi)||bar3.collides(megumi));
    }

    public void reset(int delta) {

        bar1.resets(r.nextInt(50)+0,0, 90,22,SPEED, delta);
        bar2.resets(r.nextInt(50)+0, (int) (bar1.getTailY()-GAP),90,22,SPEED, delta);
        bar3.resets(r.nextInt(50)+0, (int) (bar2.getTailY()-GAP), 90, 22, SPEED,delta);



    }

    public void setSpeed() {
        bar1.setSpeed();
        bar2.setSpeed();
        bar3.setSpeed();
    }
}
