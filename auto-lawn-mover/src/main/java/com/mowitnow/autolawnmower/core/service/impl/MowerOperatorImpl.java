package com.mowitnow.autolawnmower.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mowitnow.autolawnmower.core.exception.MowerBusinessProcessException;
import com.mowitnow.autolawnmower.core.model.Direction;
import com.mowitnow.autolawnmower.core.model.Mower;
import com.mowitnow.autolawnmower.core.model.MowerCommand;
import com.mowitnow.autolawnmower.core.model.MowerInput;
import com.mowitnow.autolawnmower.core.model.Position;
import com.mowitnow.autolawnmower.core.service.CommandProcessor;
import com.mowitnow.autolawnmower.core.service.MowerOperator;
import com.mowitnow.autolawnmower.core.service.factory.CommandProcessorFactory;
import com.mowitnow.autolawnmower.core.validator.Validator;
import com.mowitnow.autolawnmower.core.validator.ValidatorType;
import com.mowitnow.autolawnmower.core.validator.factory.BusinessValidatorFactory;

public class MowerOperatorImpl implements MowerOperator {
	

	@Override
	public List<Mower> initMower(MowerInput mowerInput) {

		List<Mower> mowers = new ArrayList<>();

		Validator mandatoryInputValidator = BusinessValidatorFactory.produce(ValidatorType.MANDATORY_INPUT_VALIDATOR);
		mandatoryInputValidator.validate(mowerInput);

		Validator boundaryPositionValidator = BusinessValidatorFactory
				.produce(ValidatorType.BOUNDARY_POSITION_VALIDATOR);
		System.out.println("MowerInput is::: "+mowerInput);
		boundaryPositionValidator.validate(mowerInput.getBoundary());
		String[] boundaries = mowerInput.getBoundary().trim().split(" ");
		Position boundaryPosition = new Position(Integer.parseInt(boundaries[0]), Integer.parseInt(boundaries[1]));

		if (!(mowerInput.getInitialPositions().size() == mowerInput.getInstructions().size())) {
			throw new MowerBusinessProcessException(
					"Initial Positions given should match number of Instructions given for Mower Creation");
		}

		int indexSize = mowerInput.getInstructions().size();

		Validator initialPositionValidator = BusinessValidatorFactory.produce(ValidatorType.INITIAL_POSITION_VALIDATOR);
		Validator commandValidator = BusinessValidatorFactory.produce(ValidatorType.COMMAND_VALIDATOR);

		for (int index = 0; index < indexSize; index++) {

			initialPositionValidator.validate(mowerInput.getInitialPositions());
			String[] positionStrArr = mowerInput.getInitialPositions().get(index).split(" ");

			Direction direction = null;
			Optional<Direction> directionOptional = Direction.getDirectionFromCode(positionStrArr[2]);
			if (directionOptional.isPresent()) {
				direction = directionOptional.get();
			}
			Position initialPosition = new Position(Integer.parseInt(positionStrArr[0]),
					Integer.parseInt(positionStrArr[1]));
			initialPosition.setDirection(direction);

			commandValidator.validate(mowerInput.getInstructions());
			char[] instructionArr = mowerInput.getInstructions().get(index).toCharArray();
			List<MowerCommand> commands = new ArrayList<>();
			for (char instruction : instructionArr) {
				Optional<MowerCommand> mowerCommandOptional = MowerCommand
						.getMowerCommandFromCode(String.valueOf(instruction));

				if (mowerCommandOptional.isPresent()) {
					commands.add(mowerCommandOptional.get());
				}

			}
			Mower mower = new Mower(initialPosition, boundaryPosition, commands);
			mowers.add(mower);
		}
		return mowers;

	}

	@Override
	public List<Position> runMower(List<Mower> mowers) {

		CommandProcessor commandProcessor = CommandProcessorFactory.createCommandProcess();

		List<Position> finalPositions = new ArrayList<>(mowers.size());

		mowers.stream().forEachOrdered(mower -> {
			finalPositions.add(commandProcessor.processCommand(mower));
		});

		return finalPositions;
	}

}
