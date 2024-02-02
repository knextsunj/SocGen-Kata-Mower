package com.mowitnow.autolawnmower.core.model;

public class Position {

	private int x;

	private int y;

	private Direction direction;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return x + " " + y + " " + direction;
	}

}
