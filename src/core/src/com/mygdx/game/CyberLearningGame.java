package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CyberLearningGame extends Game {
	SpriteBatch batch;
	BitmapFont font;
	OrthographicCamera camera;
	public static int screenX = 800;
	public static int screenY = 480;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		setScreen(new TitleScreen(this));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, screenX, screenY);
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}
