package com.mowitnow.autolawnmower.core.model;

import java.util.List;

public class Mower {

	private Position position;

	private final Position boundaryPosition;

	private final List<MowerCommand> mowerCommands;

	public Mower(Position position, Position boundaryPosition, List<MowerCommand> mowerCommands) {
		this.position = position;
		this.boundaryPosition = boundaryPosition;
		this.mowerCommands = mowerCommands;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Position getBoundaryPosition() {
		return boundaryPosition;
	}

	public List<MowerCommand> getMowerCommands() {
		return mowerCommands;
	}

}
