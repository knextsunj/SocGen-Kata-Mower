package com.mowitnow.autolawnmower.core.service.factory;

import com.mowitnow.autolawnmower.core.service.MowerOperator;
import com.mowitnow.autolawnmower.core.service.impl.MowerOperatorImpl;

public final class MowerOperatorFactory {

	public static MowerOperator createMowerOperator() {
		return new MowerOperatorImpl();
	}
}
