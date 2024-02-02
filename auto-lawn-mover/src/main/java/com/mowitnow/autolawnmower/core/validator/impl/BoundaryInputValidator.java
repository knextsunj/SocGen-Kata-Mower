package com.mowitnow.autolawnmower.core.validator.impl;

import com.mowitnow.autolawnmower.core.exception.MowerBusinessProcessException;
import com.mowitnow.autolawnmower.core.validator.Validator;

public class BoundaryInputValidator implements Validator<String> {

	@Override
	public void validate(String input) {
		
		if(!input.matches("^[0-9] [0-9]$")) {
			throw new MowerBusinessProcessException("Valid boundary input positions not received");
		}
	}

}
