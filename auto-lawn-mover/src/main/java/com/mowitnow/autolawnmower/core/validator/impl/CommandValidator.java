package com.mowitnow.autolawnmower.core.validator.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mowitnow.autolawnmower.core.exception.MowerBusinessProcessException;
import com.mowitnow.autolawnmower.core.model.MowerCommand;
import com.mowitnow.autolawnmower.core.validator.Validator;

public class CommandValidator implements Validator<List<String>> {

	@Override
	public void validate(List<String> instructions) {
		for (String instruction : instructions) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(MowerCommand.ADVANCE);
			stringBuilder.append(MowerCommand.LEFT);
			stringBuilder.append(MowerCommand.RIGHT);
			if (!StringUtils.containsOnly(instruction, stringBuilder.toString())) {
				throw new MowerBusinessProcessException("Invalid instructions found");
			}
		}
	}

}
