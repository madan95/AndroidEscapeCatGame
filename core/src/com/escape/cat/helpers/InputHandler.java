package com.escape.cat.helpers;

import com.badlogic.gdx.InputProcessor;

import com.escape.cat.gameworld.GameWorld;
import com.escape.cat.megumi.Megumi;


/**
 * Created by Madan on 17/10/2016.
 */

public class InputHandler implements InputProcessor{
    private Megumi myMegumi;
    private static boolean isDown = false;

    private int fingerOne, fingerTwo;

private GameWorld myWorld;
    public InputHandler(GameWorld myWorld) {
        this.myWorld = myWorld;
        myMegumi = myWorld.getMegumi();
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(!(myMegumi.isFirs()&&myMegumi.isSecond())) {
            myMegumi.setFirs(true);
            fingerOne = pointer;
        }else if(!myMegumi.isSecond()&&myMegumi.isFirs()){
            myMegumi.setSecond(true);
            fingerTwo=pointer;
        }else if(!myMegumi.isFirs()&&myMegumi.isSecond()){
            myMegumi.setFirs(true);
            fingerOne = pointer;
        }
        isDown = true;
          myMegumi.onClick(screenX, screenY, isDown);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(pointer==fingerOne && !myMegumi.isSecond()){
            myMegumi.setFirs(false);
            isDown=false;
            myMegumi.onClick(screenX,screenY,isDown);
        }
        if(pointer==fingerTwo && !myMegumi.isFirs()) {
            myMegumi.setSecond(false);
            isDown = false;
            myMegumi.onClick(screenX, screenY, isDown);
        }

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
