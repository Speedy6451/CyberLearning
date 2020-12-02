package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class GameObject {
	public Vector2 pos;
	public boolean isVisible;
	public GameObject(Vector2 pos) {
		this.pos = pos;
		this.isVisible = false;
	}
}
