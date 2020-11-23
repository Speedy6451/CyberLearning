package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture coinTexture1;
	BitmapFont font;
	Music rainMusic;
	OrthographicCamera camera;
	public static int screenX = 800;
	public static int screenY = 480; 

	public enum GameState {
		TITLE, 
		MENU, 
		CREDITS, 
		LEVEL, 
		LOSE
	}; 
	GameState gameState;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		// coinTexture1 = new Texture("");
		font = new BitmapFont();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, screenX, screenY);
		gameState = GameState.TITLE;

		// load music
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("music/New Hope.ogg"));
		//play music on loop
		rainMusic.setLooping(true);
		rainMusic.play();
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		switch (gameState) {
			case TITLE:
				font.draw(batch, "Cool Game Title", screenX / 2, screenY / 2);
				break;
		}
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
