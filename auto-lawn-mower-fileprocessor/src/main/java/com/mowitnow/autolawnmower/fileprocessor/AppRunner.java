package com.mowitnow.autolawnmower.fileprocessor;


import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mowitnow.autolawnmower.core.model.Mower;
import com.mowitnow.autolawnmower.core.model.MowerInput;
import com.mowitnow.autolawnmower.core.model.Position;
import com.mowitnow.autolawnmower.core.service.MowerOperator;
import com.mowitnow.autolawnmower.core.service.factory.MowerOperatorFactory;
import com.mowitnow.autolawnmower.fileprocessor.exception.MowerFileProcessorException;
import com.mowitnow.autolawnmower.fileprocessor.service.FileReaderService;



public class AppRunner 
{
	
	private static final Logger logger = LogManager.getLogger(AppRunner.class);
	
    public static void main(String[] args)
    {
		if(args == null || args.length == 0) {
		logger.error("Input file not provided for processing");
		throw new MowerFileProcessorException("Input file not provided");
	}
    
	
	FileReaderService fileReaderService = FileReaderService.getInstance();
	Optional<MowerInput> mowerInputOptional = fileReaderService.read(args[0]);
	if(mowerInputOptional.isPresent()) {
		MowerOperator mowerOperator = MowerOperatorFactory.createMowerOperator();
		List<Mower> mowers = mowerOperator.initMower(mowerInputOptional.get());
		List<Position> finalPositions = mowerOperator.runMower(mowers);
			logger.info(" *************************************************");
			logger.info("Results are :::::");
			for (int index=0 ; index < finalPositions.size() ; index++) {
				logger.info("   " + index + " : Mower final position : " + finalPositions.get(index));
			}
			logger.info("*************************************************");
			
		
	}
    }
}
