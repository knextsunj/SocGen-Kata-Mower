package com.mowitnow.autolawnmower.core.model;

import java.util.Optional;

public enum Direction {

	NORTH("N", "W", "E"), SOUTH("S", "E", "W"), WEST("W", "S", "N"), EAST("E", "N", "S");

	private final String code;

	private final String left;

	private final String right;

	private Direction(String code, String left, String right) {
		this.code = code;
		this.left = left;
		this.right = right;
	}

	public String getCode() {
		return code;
	}

	public static Optional<Direction> getDirectionFromCode(String code) {
		for (Direction direction : Direction.values()) {
			if (direction.code.equals(code)) {
				return Optional.of(direction);
			}
		}
		return Optional.empty();
	}

	public Optional<Direction> getLeftDirection() {
		return getDirectionFromCode(left);
	}

	public Optional<Direction> getRightDirection() {
		return getDirectionFromCode(right);
	}

}
