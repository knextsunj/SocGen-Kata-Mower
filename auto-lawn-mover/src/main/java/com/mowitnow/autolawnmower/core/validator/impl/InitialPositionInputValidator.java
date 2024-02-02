package com.mowitnow.autolawnmower.core.validator.impl;

import java.util.List;

import com.mowitnow.autolawnmower.core.exception.MowerBusinessProcessException;
import com.mowitnow.autolawnmower.core.validator.Validator;

public class InitialPositionInputValidator implements Validator<List<String>> {

	@Override
	public void validate(List<String> initialPositions) {
		for (String initialPosition : initialPositions) {
			if (!initialPosition.matches("^[0-9] [0-9] (N|S|W|E)$")) {
				throw new MowerBusinessProcessException("Valid initial input positions not received");
			}
		}
	}

}
