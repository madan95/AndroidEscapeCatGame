package com.escape.cat.gameworld;

import com.badlogic.gdx.Gdx;
import com.escape.cat.gameobject.ScrollHandler;
import com.escape.cat.helpers.AssetLoader;
import com.escape.cat.megumi.Megumi;


/**
 * Created by Madan on 17/10/2016.
 */

public class GameWorld {

    private Megumi megumi;
    private ScrollHandler scroller;
    private int score=  0;
    private boolean realAlive = true;
    private boolean isSpeeded = false;
    private int tempScore = 0;
    public GameWorld(int midPointX, int positionY) {
         megumi=new Megumi(midPointX, positionY, 20,20);
         scroller = new ScrollHandler(this);
    }

    public void update(float delta) {
        megumi.update(delta);
        scroller.update(delta);

     /*(   if(score == 5 && realAlive == true){
            scroller.setSpeed();
        }
        if(score == 10 && realAlive == true){
            scroller.setSpeed();
        }
       #
*/

        if((score==10 || score == 20 || score ==30 || score ==40 || score ==50 || score ==60 || score ==70 || score ==80 || score ==100)&& realAlive == true && isSpeeded == false){
           tempScore = score;
                setSpeedUp();
            if(score ==40 || score ==80) {
                megumi.speedUp();
            }
            isSpeeded = true;

                    }

        if((score > tempScore)){
            isSpeeded = false;
        }

        if (scroller.collides(megumi) && realAlive == true) {
                scroller.stop();
                megumi.stop();
                realAlive = false;

            }

        if (realAlive == false && Gdx.input.justTouched()) {

            megumi.reset(delta);
            scroller.reset((int) delta);
            score = 0;
            realAlive= true;
            isSpeeded = false;
        }

        if (score > AssetLoader.getHighScore()) {
            AssetLoader.setHighScore(score);
        }


    }


    public int getScore(){
        return score;
    }

    public ScrollHandler getScroller(){
        return scroller;
    }

    public void addScore(int adder){score +=adder;}
    public Megumi getMegumi() {
        return megumi;
    }

    public boolean isRealAlive(){
        return realAlive;
    }

    public void setSpeedUp() {
        scroller.setSpeed();
    }
}

