package com.mowitnow.autolawnmower.core.validator.impl;

import java.util.Objects;

import com.mowitnow.autolawnmower.core.exception.MowerBusinessProcessException;
import com.mowitnow.autolawnmower.core.model.MowerInput;
import com.mowitnow.autolawnmower.core.validator.Validator;

public class MandatoryInputParameterValidator implements Validator<MowerInput> {

	@Override
	public void validate(MowerInput mowerInput) {
		if (Objects.isNull(mowerInput) || Objects.isNull(mowerInput.getInitialPositions())
				|| mowerInput.getInitialPositions().isEmpty() || Objects.isNull(mowerInput.getInstructions())
				|| mowerInput.getInstructions().isEmpty()) {
			throw new MowerBusinessProcessException("Required inputs not available for mower initialization");
		}
	}


}
