package com.escape.cat.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.escape.cat.gameworld.GameWorld;
import com.escape.cat.gameworld.GameRenderer;
import com.escape.cat.helpers.InputHandler;

/**
 * Created by Madan on 17/10/2016.
 */

public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runtTime=0;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight= Gdx.graphics.getHeight();
        float gameHeight = screenHeight/(screenWidth/136);
        float positionY = gameHeight -30;
        float midPointX = (screenWidth/(screenHeight/204))/2;

        world = new GameWorld((int) midPointX, (int) positionY);
        renderer = new GameRenderer(world);

       Gdx.input.setInputProcessor(new InputHandler(world));
    }

    @Override
    public void render(float delta) {
       // Gdx.app.log("GameScreen FPS", (1/delta)+"");
        runtTime+=delta;

        world.update(delta);
        renderer.render(runtTime);


    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
