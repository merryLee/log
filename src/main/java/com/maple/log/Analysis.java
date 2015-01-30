package com.maple.log;

import java.util.*;

public class Analysis {

	public Vector<LogFile> logVector;

	StatusCode statusCode = new StatusCode();
	URL url = new URL();
	WebBrowser webBrowser = new WebBrowser();
	Time time = new Time();

	public void setLogVector(Vector<LogFile> logVector) {
		this.logVector = logVector;
	}

	public void print() {

	}
}