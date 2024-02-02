package com.mowitnow.autolawnmower.core.validator;

public enum ValidatorType {

	MANDATORY_INPUT_VALIDATOR("mowerInputValidator"),
	BOUNDARY_POSITION_VALIDATOR("boundaryPositionValidator"),
	INITIAL_POSITION_VALIDATOR("initialPositionValidator"),
	COMMAND_VALIDATOR("commandValidator");

	private final String code;

	private ValidatorType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
