package com.maple.log;

import java.util.Iterator;
import java.util.Vector;

public class Time {

	int count = 0;
	String name;

	AnalysisCode max = new AnalysisCode();

	public void calculate(Vector<LogFile> logVector) {

		Iterator<LogFile> it = logVector.iterator();

		LogFile log = it.next();
		name = log.getTime();

		while (it.hasNext()) {

			log = it.next();

			if (log != null) {
				setMax(log);
			}
		}

	}

	public void setMax(LogFile log) {

		if (log.getTime().equals(name)) {
			count++;
		}
		else {
			if (count >= max.count) {
				max.count = count;
				max.name = name;
			}

			count = 0;
			name = log.getTime();
		}
		
	}

}
