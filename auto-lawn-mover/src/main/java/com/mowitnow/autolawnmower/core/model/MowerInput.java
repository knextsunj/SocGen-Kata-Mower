package com.mowitnow.autolawnmower.core.model;

import java.util.List;

public class MowerInput {

	private final String boundary;

	private final List<String> initialPositions;

	private final List<String> instructions;

	public MowerInput(MowerInputBuilder mowerInputBuilder) {
		this.boundary = mowerInputBuilder.boundaryPos;
		this.initialPositions = mowerInputBuilder.initialPositionList;
		this.instructions = mowerInputBuilder.instructionList;
	}

	public String getBoundary() {
		return boundary;
	}

	public List<String> getInitialPositions() {
		return initialPositions;
	}

	public List<String> getInstructions() {
		return instructions;
	}

	public static class MowerInputBuilder {

		private String boundaryPos;

		private List<String> initialPositionList;

		private List<String> instructionList;

		public String getBoundaryPos() {
			return boundaryPos;
		}

		public MowerInputBuilder setBoundaryPos(String boundaryPos) {
			this.boundaryPos = boundaryPos;
			return this;
		}

		public List<String> getInitialPositionList() {
			return initialPositionList;
		}

		public MowerInputBuilder setInitialPositionList(List<String> initialPositionList) {
			this.initialPositionList = initialPositionList;
			return this;
		}

		public List<String> getInstructionList() {
			return instructionList;
		}

		public MowerInputBuilder setInstructionList(List<String> instructionList) {
			this.instructionList = instructionList;
			return this;
		}

		public MowerInput build() {
			return new MowerInput(this);
		}
	}

	@Override
	public String toString() {
		return "MowerInput [boundary=" + boundary + ", initialPositions=" + initialPositions + ", instructions="
				+ instructions + "]";
	}

	
}
