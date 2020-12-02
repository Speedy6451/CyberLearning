package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Consumable extends GameObject {
	public boolean pickedUp;

	public Consumable(Vector2 pos) {
		super(pos);
		this.pickedUp = false;
		this.isVisible = !pickedUp;
	}

	public void use() {
		this.pickedUp = true;
		this.isVisible = !pickedUp;
	}
}
