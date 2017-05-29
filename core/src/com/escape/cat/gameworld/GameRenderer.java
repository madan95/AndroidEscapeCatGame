package com.escape.cat.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.escape.cat.megumi.Megumi;
import com.escape.cat.gameobject.ScrollHandler;
import com.escape.cat.helpers.AssetLoader;
import com.escape.cat.gameobject.Bar;

/**
 * Created by Madan on 17/10/2016.
 */

public class GameRenderer {
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    private int midPointY;
    private int gameHeight;
    private Megumi megumi;

    private ScrollHandler scroller;
    private Bar bar1, bar2, bar3;

    private TextureRegion bg,obs, player;

    public GameRenderer(GameWorld world) {

        myWorld = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(true,136,204);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        shapeRenderer= new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);


        // Call helper methods to initialize instance variable
        initGameObjects();
        initAssets();
    }

    public void render(float runTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        batcher.begin();
        batcher.draw(bg,0,0,136,204);
        drawObs();
        batcher.draw(player, megumi.getX(), megumi.getY(), megumi.getWidth(), megumi.getHeight());
        String score = myWorld.getScore()+"";

        AssetLoader.font12.draw(batcher,score,136/2-(score.length()), 30);
       // AssetLoader.shadow.draw(batcher, score,136/2-(score.length()), 30);
        //AssetLoader.font.draw(batcher, score,136/2-(score.length()),  30);

        if(!myWorld.isRealAlive()){


            batcher.draw(AssetLoader.death.getKeyFrame(runTime), megumi.getX(), megumi.getY(), megumi.getWidth(), megumi.getHeight());

            String tryAgain = "Try Again ?";
           // AssetLoader.shadow.draw(batcher, tryAgain,(136/2-tryAgain.length()-30), 60);
            //AssetLoader.font.draw(batcher, tryAgain, (136/2-tryAgain.length()-30),  60);

            String highScore = "High Score : " + AssetLoader.getHighScore();

            AssetLoader.font12.draw(batcher, tryAgain,(136/2-tryAgain.length()-30), 60);
            AssetLoader.font12.draw(batcher, highScore,(136/2-tryAgain.length()-50), 90);

            // AssetLoader.shadow.draw(batcher, highScore,(136/2-highScore.length()-50), 90);
           // AssetLoader.font.draw(batcher, highScore, (136/2-highScore.length())-50,  90);

        }


        batcher.end();
/*
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(megumi.getX(), megumi.getY(), megumi.getWidth(), megumi.getHeight());


        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(bar1.getBarr().x, bar1.getBarr().getY(),bar1.getBarr().width, bar1.getBarr().height);
        shapeRenderer.rect(bar2.getBarr().x, bar2.getBarr().getY(),bar2.getBarr().width, bar2.getBarr().height);
        shapeRenderer.rect(bar3.getBarr().x, bar3.getBarr().getY(),bar3.getBarr().width, bar3.getBarr().height);


        shapeRenderer.end();
  */
    }

    private void drawObs(){
        batcher.draw(obs, bar1.getBarr().x, bar1.getBarr().getY(),bar1.getBarr().width, bar1.getBarr().height);
        batcher.draw(obs, bar2.getBarr().x, bar2.getBarr().getY(),bar2.getBarr().width, bar2.getBarr().height);
        batcher.draw(obs, bar3.getBarr().x, bar3.getBarr().getY(),bar3.getBarr().width, bar3.getBarr().height);

    }

    private void initGameObjects() {
        megumi = myWorld.getMegumi();
        scroller = myWorld.getScroller();
        bar1 = scroller.getBar1();
        bar2 = scroller.getBar2();
        bar3 = scroller.getBar3();

    }

    private void initAssets(){
        bg = AssetLoader.bg;
        obs = AssetLoader.obs;
        player = AssetLoader.player;

    }



}
