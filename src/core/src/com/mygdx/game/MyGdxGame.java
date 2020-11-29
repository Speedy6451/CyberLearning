package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	BitmapFont font;
	public OrthographicCamera camera;
	public static int screenX = 800;
	public static int screenY = 480;
	public static Vector3 backgroundColor = new Vector3(0.1451f, 0.0745f, 0.1020f);
	public float volume;

	@Override
	public void create () {
		volume = .1f;
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("fonts/arcadeclassic.fnt"));
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
