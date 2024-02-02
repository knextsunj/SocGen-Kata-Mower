package com.mowitnow.autolawnmower.core.service;

import java.util.List;

import com.mowitnow.autolawnmower.core.model.Mower;
import com.mowitnow.autolawnmower.core.model.MowerCommand;
import com.mowitnow.autolawnmower.core.model.Position;

public interface CommandProcessor {
	
	Position processCommand(Mower mower);

}
