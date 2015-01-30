package com.maple.log;

import java.util.Iterator;
import java.util.Vector;

public class StatusCode {

	AnalysisCode error = new AnalysisCode("10");
	AnalysisCode success = new AnalysisCode("200");
	AnalysisCode notFound = new AnalysisCode("404");

	public void calculate(Vector<LogFile> logVector) {

		Iterator<LogFile> it = logVector.iterator();

		while (it.hasNext()) {
			LogFile log = it.next();

			if (log != null) {
				setCount(log);
			}
		}

	}

	public void setCount(LogFile log) {

		if (error.getName().equals(log.getStatus())) {
			error.count++;
		} else if (success.getName().equals(log.getStatus())) {
			success.count++;
		} else if (notFound.getName().equals(log.getStatus())) {
			notFound.count++;
		} else {
		}
	}

}
