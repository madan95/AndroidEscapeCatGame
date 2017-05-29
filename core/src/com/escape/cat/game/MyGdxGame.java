package com.escape.cat.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.escape.cat.helpers.AssetLoader;
import com.escape.cat.megumi.*;
import com.escape.cat.util.ScreenManager;

public class MyGdxGame extends Game {

	@Override
	public void create() {

		Gdx.app.log("MyGdxGame", "Created");
		com.escape.cat.helpers.AssetLoader.load();
		setScreen(new ScreenManager(this));
		//setScreen(new GameScreen());
	}
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();

	}
}
