package com.maple.log;

import java.io.*;

public class FileOutput extends Analysis {

	public void output(String outputFile) throws IOException {

		FileWriter out;

		out = new FileWriter(outputFile);

		
		
		// fout.write(""+ "\r\n");

		out.close();

	}

}
