package com.mowitnow.autolawnmower.core.service.factory;

import com.mowitnow.autolawnmower.core.service.CommandProcessor;
import com.mowitnow.autolawnmower.core.service.impl.CommandProcessorImpl;

public final class CommandProcessorFactory {

	public static CommandProcessor createCommandProcess() {
		return new CommandProcessorImpl();
	}

}
