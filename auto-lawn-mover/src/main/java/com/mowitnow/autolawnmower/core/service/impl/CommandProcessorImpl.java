package com.mowitnow.autolawnmower.core.service.impl;

import java.util.Optional;

import com.mowitnow.autolawnmower.core.model.Direction;
import com.mowitnow.autolawnmower.core.model.Mower;
import com.mowitnow.autolawnmower.core.model.Position;
import com.mowitnow.autolawnmower.core.service.CommandProcessor;

public class CommandProcessorImpl implements CommandProcessor {

	@Override
	public Position processCommand(Mower mower) {

		mower.getMowerCommands().stream().forEachOrdered(command->{
			
			switch(command) {
			case ADVANCE:
				mower.setPosition(advanceWithinBoundaryLimits(mower.getPosition(),mower.getBoundaryPosition(),mower.getPosition().getDirection()));
				break;
				
			case LEFT:
				mower.setPosition(turnLeftDirection(mower.getPosition()));
				break;
				
			case RIGHT:
				mower.setPosition(turnRightDirection(mower.getPosition()));
				break;
			}
		});
		return mower.getPosition();
	}
	
	private Position advanceWithinBoundaryLimits(Position position,Position boundaryPosition,Direction direction) {
		
		
		switch(direction) {
		case NORTH :
			if (position.getY() < boundaryPosition.getY()) { position.setY(position.getY()+1); }
			break;
		case SOUTH :
			if (position.getY() > 0) { position.setY(position.getY()-1); }
			break;
		case EAST :
			if (position.getX() < boundaryPosition.getX()) { position.setX(position.getX()+1); }
			break;
		case WEST :
			if (position.getX() > 0) { position.setX(position.getX()-1); }
			break;
	}
		return position;
	}

	private Position turnLeftDirection(Position position) {
		Direction direction = position.getDirection();
		Optional<Direction> newDirectionOptional = direction.getLeftDirection();
		if(newDirectionOptional.isPresent()) {
			position.setDirection(newDirectionOptional.get());
		}
		return position;
	}
	
	private Position turnRightDirection(Position position) {
		Direction direction = position.getDirection();
		Optional<Direction> newDirectionOptional = direction.getRightDirection();
		if(newDirectionOptional.isPresent()) {
			position.setDirection(newDirectionOptional.get());
		}
		return position;
	}
	
}
