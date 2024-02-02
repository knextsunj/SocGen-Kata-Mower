package com.mowitnow.autolawnmower.core.validator.factory;

import com.mowitnow.autolawnmower.core.validator.Validator;
import com.mowitnow.autolawnmower.core.validator.ValidatorType;
import com.mowitnow.autolawnmower.core.validator.impl.BoundaryInputValidator;
import com.mowitnow.autolawnmower.core.validator.impl.CommandValidator;
import com.mowitnow.autolawnmower.core.validator.impl.InitialPositionInputValidator;
import com.mowitnow.autolawnmower.core.validator.impl.MandatoryInputParameterValidator;

public final class BusinessValidatorFactory {

	public static Validator produce(ValidatorType validatorType) {

		switch (validatorType) {
		case MANDATORY_INPUT_VALIDATOR:
			return new MandatoryInputParameterValidator();

		case BOUNDARY_POSITION_VALIDATOR:
			return new BoundaryInputValidator();

		case INITIAL_POSITION_VALIDATOR:
			return new InitialPositionInputValidator();

		case COMMAND_VALIDATOR:
			return new CommandValidator();

		default:
			throw new IllegalArgumentException("Type unknown");
		}
	}

}
