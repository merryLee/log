package com.maple.log;

import java.io.*;
import java.util.*;

public class FileInput {

	// public ArrayList<LogFile> allList = new ArrayList<LogFile>();
	// public Vector<LogFile> allVector = new Vector<LogFile>();

	public void input() throws IOException {

		FileReader in = new FileReader("input.log");
		BufferedReader bin = new BufferedReader(in);

		String logLine = bin.readLine();
		System.out.println(logLine);

		setLogFile(logLine);

		in.close();
		bin.close();
	}

	public void setLogFile(String logLine) {

		LogFile log = new LogFile();

		StringTokenizer st = new StringTokenizer(logLine, "[]");
		log.setStatus(st.nextToken());
		log.setURL(st.nextToken());
		log.setWeb(st.nextToken());
		log.setTime(st.nextToken());
	}

}
