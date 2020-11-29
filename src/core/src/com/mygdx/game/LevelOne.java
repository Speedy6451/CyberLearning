package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.GL20;

public class LevelOne extends ScreenAdapter {
	MyGdxGame game;
	TiledMap map;
	TiledMapRenderer tiledMapRenderer;
	Music music;

	public LevelOne(MyGdxGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		// play background music (tbd)
		// music = Gdx.audio.newMusic(Gdx.files.internal("music/[tbd]"));
		// music =music.setLooping(true);
		// music =music.play();

		map = new TmxMapLoader().load("levels/level1.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, .25f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.camera.update();
		tiledMapRenderer.setView(game.camera);
		tiledMapRenderer.render();
	}

	@Override
	public void hide() {
		// music.stop();
		// music.dispose();
		map.dispose();
	}
}

