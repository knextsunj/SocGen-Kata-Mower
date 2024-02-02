package com.mowitnow.autolawnmower.core.service;

import java.util.List;
import java.util.Optional;

import com.mowitnow.autolawnmower.core.model.Mower;
import com.mowitnow.autolawnmower.core.model.MowerInput;
import com.mowitnow.autolawnmower.core.model.Position;

public interface MowerOperator {

	List<Mower> initMower(MowerInput mowerInput);

	List<Position> runMower(List<Mower> mowers);

}
