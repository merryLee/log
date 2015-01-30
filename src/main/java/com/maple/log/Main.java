package com.maple.log;

import java.io.IOException;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String inputFile, outputFile;

		Vector<LogFile> logVector = new Vector<LogFile>();
		
		FileInput fileInput = new FileInput();
		FileOutput fileOutput = new FileOutput();
		Analysis analysis = new Analysis();
		
		inputFile = "input.log";
		outputFile = "output.log";

		fileInput.setLogVector(logVector);
		
		logVector = fileInput.input(inputFile);
		analysis.setLogVector(logVector);
		
		
		analysis.print();

		fileOutput.output(outputFile);

	}

}
