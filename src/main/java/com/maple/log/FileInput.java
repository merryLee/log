package com.maple.log;

import java.io.*;
import java.util.*;

public class FileInput {

	private Vector<LogFile> logVector;

	public void setLogVector(Vector<LogFile> logVector) {
		this.logVector = logVector;
	}
	
	public Vector<LogFile> input(String inputFile) throws IOException {

		FileReader in = new FileReader(inputFile);
		BufferedReader bin = new BufferedReader(in);

		while(bin.read()!=-1)
		{
			LogFile log = new LogFile();
			
			String line = bin.readLine();
			setLogFile(log, line);	

			logVector.add(log);
		}

		in.close();
		bin.close();
		
		return logVector;
	}

	public void setLogFile(LogFile logFile, String line) {

		StringTokenizer st = new StringTokenizer(line, "[]");
		logFile.setStatus(st.nextToken());
		logFile.setURL(st.nextToken());
		logFile.setWeb(st.nextToken());
		logFile.setTime(st.nextToken());
	}
	
}
