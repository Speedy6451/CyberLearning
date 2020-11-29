package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class LevelOne extends ScreenAdapter {
	MyGdxGame game;
	TiledMap map;
	TiledMapRenderer tiledMapRenderer;
	Music music;
	float deltaT = 0;
	boolean w = false;
	boolean a = false;
	boolean s = false;
	boolean d = false;

	public LevelOne(MyGdxGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		// play background music
		music = Gdx.audio.newMusic(Gdx.files.internal("music/Soliloquy.mp3"));
		music.setLooping(false);
		music.setVolume(game.volume);
		music.play();

		map = new TmxMapLoader().load("levels/level1.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
		game.camera.setToOrtho(false,10*16,6*16);

		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean keyDown(int keyCode) {
				if (keyCode == Input.Keys.W) {
					w = true;
				}
				if (keyCode == Input.Keys.S) {
					s = true;
				}
				if (keyCode == Input.Keys.A) {
					a = true;
				}
				if (keyCode == Input.Keys.D) {
					d = true;
				}
				return true;
			}
			public boolean keyUp(int keyCode) {
				if (keyCode == Input.Keys.W) {
					w = false;
				}
				if (keyCode == Input.Keys.S) {
					s = false;
				}
				if (keyCode == Input.Keys.A) {
					a = false;
				}
				if (keyCode == Input.Keys.D) {
					d = false;
				}
				return true;
			}
		});
	}

	@Override
	public void render(float delta) {
		deltaT = delta;
		Gdx.gl.glClearColor(0, .25f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.camera.update();
		tiledMapRenderer.setView(game.camera);
		tiledMapRenderer.render();
		if (w) {
			game.camera.translate(0f, 32f*delta);
		}
		if (s) {
			game.camera.translate(0f,-32f*delta);
		}
		if (a) {
			game.camera.translate(-32f*delta,0f);
		}
		if (d) {
			game.camera.translate(32f*delta,0f);
		}
	}

	@Override
	public void hide() {
		// music.stop();
		// music.dispose();
		map.dispose();
	}
}

