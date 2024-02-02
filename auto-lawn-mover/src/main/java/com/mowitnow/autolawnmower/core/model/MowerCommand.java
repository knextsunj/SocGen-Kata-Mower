package com.mowitnow.autolawnmower.core.model;

import java.util.Optional;

public enum MowerCommand {

	ADVANCE("A"), LEFT("G"), RIGHT("D");

	private final String code;

	private MowerCommand(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static Optional<MowerCommand> getMowerCommandFromCode(String code) {
		for (MowerCommand mowerCommand : MowerCommand.values()) {
			if (mowerCommand.code.equals(code)) {
				return Optional.of(mowerCommand);
			}
		}
		return Optional.empty();
	}

}
