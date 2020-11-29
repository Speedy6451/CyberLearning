package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;

public class TitleScreen extends ScreenAdapter {
	CyberLearningGame game;
	Music titleMusic;

	public TitleScreen(CyberLearningGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		// play title music
		titleMusic =  Gdx.audio.newMusic(Gdx.files.internal("music/New Hope.ogg"));
		titleMusic.setLooping(true);
		titleMusic.play();

		// go to level1 on enter press
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean keyDown(int keyCode) {
				if (keyCode == Input.Keys.ENTER) {
					game.setScreen(new LevelOne(game));
					}
					return true;
				}
			});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, .25f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.font.draw(game.batch, "I forgot the title", CyberLearningGame.screenX/4, CyberLearningGame.screenY*.75f);
		game.font.draw(game.batch, "Press enter to begin", CyberLearningGame.screenX/4, CyberLearningGame.screenY/2);
		game.batch.end();

	}
	@Override 
	public void hide() {
		titleMusic.stop();
		titleMusic.dispose();
		Gdx.input.setInputProcessor(null);
	}
}
