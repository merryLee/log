package com.maple.log;

import java.util.Iterator;
import java.util.Vector;

public class WebBrowser {

	AnalysisCode ie = new AnalysisCode("IE");
	AnalysisCode firefox = new AnalysisCode("Firefox");
	AnalysisCode safari = new AnalysisCode("Safari");
	AnalysisCode chrome = new AnalysisCode("Chrome");
	AnalysisCode opera = new AnalysisCode("Opera");
	
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

		if (ie.getName().equals(log.getStatus())) {
			ie.count++;
		} else if (firefox.getName().equals(log.getStatus())) {
			firefox.count++;
		} else if (safari.getName().equals(log.getStatus())) {
			safari.count++;
		} else if (chrome.getName().equals(log.getStatus())) {
			chrome.count++;
		} else if (opera.getName().equals(log.getStatus())) {
			opera.count++;
		} else {
		}
	}

	public void setPercentage(Vector<LogFile> logVector) {

		double average = logVector.size() / 100;

		ie.percent = ie.count / average;
		firefox.percent = firefox.count / average;
		safari.percent = safari.count / average;
		chrome.percent = chrome.count / average;
		opera.percent = opera.count / average;
	}

}
