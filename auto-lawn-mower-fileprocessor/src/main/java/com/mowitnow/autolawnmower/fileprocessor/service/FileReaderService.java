package com.mowitnow.autolawnmower.fileprocessor.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.mowitnow.autolawnmower.core.model.MowerInput;
import com.mowitnow.autolawnmower.core.model.MowerInput.MowerInputBuilder;

public class FileReaderService {

	private static FileReaderService INSTANCE;

	private FileReaderService() {
	}

	public static FileReaderService getInstance() {
		if (null == INSTANCE) {
			INSTANCE = new FileReaderService();
		}
		return INSTANCE;
	}

	public Optional<MowerInput> read(String fileName) {

		MowerInput.MowerInputBuilder mowerInputBuilder = new MowerInputBuilder();
		List<String> initialPositions = new ArrayList<>();
		List<String> instructions = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEachOrdered(line -> {
				System.out.println("line length is ::: " + line.length());
				System.out.println("line is::: " + line);
				if (line.length() > 3) {
					String[] lineArr = line.trim().split(" ");
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append(lineArr[0]);
					stringBuilder.append(" ");
					stringBuilder.append(lineArr[1]);
					stringBuilder.append(" ");
					stringBuilder.append(lineArr[2]);
					initialPositions.add(stringBuilder.toString());

					instructions.add(lineArr[3]);
				} else {
					mowerInputBuilder.setBoundaryPos(line);
				}
			});

			mowerInputBuilder.setInitialPositionList(initialPositions);
			mowerInputBuilder.setInstructionList(instructions);
			return Optional.of(mowerInputBuilder.build());
		} catch (IOException ioException) {

		}
		return Optional.empty();
	}

}
