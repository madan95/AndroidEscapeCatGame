package com.escape.cat.util;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.escape.cat.game.MyGdxGame;
import com.escape.cat.helpers.AssetLoader;
import com.escape.cat.screens.GameScreen;

/**
 * Created by Madan on 24/10/2016.
 */

public class ScreenManager implements Screen{

    private MyGdxGame myGame;
    private SpriteBatch sb;
    private Texture splsh;
    private OrthographicCamera cam;
    private TextureRegion start;

    public ScreenManager(Game g){
        myGame= (MyGdxGame) g;
    }

    @Override
    public void show() {
        cam = new OrthographicCamera();
        cam.setToOrtho(true,136,204);

        sb = new SpriteBatch();
        sb.setProjectionMatrix(cam.combined);

        splsh = new Texture(Gdx.files.internal("back.png"));



    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();


        start = new TextureRegion(splsh, 0,0, splsh.getWidth(), splsh.getHeight());
        start.flip(false, true);
        sb.draw(start, 0,0, 136, 204);


        String starto = " Escape The Cats";
        AssetLoader.font12.draw(sb, starto,0,50);
        //AssetLoader.shadow.draw(sb,starto,0, 50);
        //AssetLoader.font.draw(sb, starto,0,  50);


        String start = "  Tap to Start ";
        AssetLoader.font12.draw(sb, start, 0,90);
       // AssetLoader.shadow.draw(sb,start,0, 90);
       // AssetLoader.font.draw(sb, start,0,  90);

        sb.end();

        if(Gdx.input.justTouched()){
            myGame.setScreen(new GameScreen());
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
