package com.escape.cat.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Madan on 22/10/2016.
 */

public class AssetLoader {
    public static Texture texture, bgg, playerr, death1, death2;
    public static TextureRegion bg, obs, player;
    public static BitmapFont font, shadow;
    public static FreeTypeFontGenerator generator;
    public static BitmapFont font12;

    public static Animation death;
    public static TextureRegion dead1, dead2;


    public static Preferences prefs;



    public static void load(){
        texture = new Texture(Gdx.files.internal("rback.png"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        bgg = new Texture(Gdx.files.internal("bars.png"));

        playerr = new Texture(Gdx.files.internal("x.png"));

        int textureWidth = texture.getWidth();
        int textureHeight = texture.getHeight();
        float rotationAngle = 0.f;


        bg = new TextureRegion(texture,0,0,textureWidth,textureHeight);
        bg.flip(false,true);

        obs = new TextureRegion(bgg, 0,0,bgg.getWidth(), bgg.getHeight());
        obs.flip(false, true);

        player = new TextureRegion(playerr, 0,0,playerr.getWidth(),playerr.getHeight());
        player.flip(false, true);

        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        font.getData().setScale(.24f, -.25f);

        shadow = new BitmapFont(Gdx.files.internal("shadow.fnt"));
        shadow.getData().setScale(.24f, -.25f);


        generator = new FreeTypeFontGenerator(Gdx.files.internal("mono.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size=12;
        parameter.flip = true;
        font12 = generator.generateFont(parameter);



        prefs = Gdx.app.getPreferences("catScore");
        if(!prefs.contains("highScore")){
            prefs.putInteger("highScore", 0);
        }

        death1 = new Texture(Gdx.files.internal("dead1.png"));
        dead1 = new TextureRegion(death1, 0,0, death1.getWidth(), death1.getHeight());

        death2 = new Texture(Gdx.files.internal("dead2.png"));
        dead2 = new TextureRegion(death2, 0,0, death2.getWidth(), death2.getHeight());

        TextureRegion[] deads = {dead1, dead2};
        death = new Animation(0.06f, deads);
        death.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);



    }

    public static void dispose(){

        texture.dispose();
        font.dispose();
        shadow.dispose();
        generator.dispose();
    }

    public static void setHighScore(int val){
        prefs.putInteger("highScore",val);
        prefs.flush();
    }

    public static int getHighScore(){return prefs.getInteger("highScore");}
}
