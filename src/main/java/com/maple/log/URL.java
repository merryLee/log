package com.maple.log;

import java.util.*;

public class URL {

	LogFile log;
	String string;
	Map<String, Integer> hashMap = new HashMap<String, Integer>();
	int start, end;

	public void calculateService(Vector<LogFile> logVector) {

		Iterator<LogFile> it = logVector.iterator();
		
		setString(it, "search/", "?");
		hashMap.put(string, 1);

		while (it.hasNext()) {
			log = it.next();

			if (log != null) {
				setString(it, "search/", "?");
				setHashMap(string, hashMap);
			}
		}
		getTopService();
	}

	public void calculateApiKey(Vector<LogFile> logVector) {

		Iterator<LogFile> it = logVector.iterator();
		
		setString(it, "apikey=", "&");
		hashMap.put(string, 1);

		while (it.hasNext()) {
			log = it.next();

			if (log != null) {
				setString(it, "apikey=", "&");				
				setHashMap(string, hashMap);
			}
		}
		searchMaxApikey();
	}

	
	private void getTopService() {
		List<Integer> strList = createList();

		Set<String> keySet = hashMap.keySet();
		int maxValue = 0;
		String maxKey = null;

		for (String s : keySet) {
			Integer score = hashMap.get(s);
			if (score == strList.get(2)) {
				maxKey = s;
			}
		}

		System.out.println(maxKey + strList.get(2));
	}

	private List<Integer> createList() {
		List<Integer> valueList = new ArrayList<Integer>();

		Set<String> keySet = hashMap.keySet();

		for (String s : keySet) {
			Integer score = hashMap.get(s);
			valueList.add(score);
		}

		Collections.sort(valueList);
		Collections.reverse(valueList);

		return valueList;
	}
	
	private void searchMaxApikey() {
		Set<String> keySet = hashMap.keySet();
		int maxValue = 0;
		String maxKey = null;

		for (String s : keySet) {
			Integer score = hashMap.get(s);
			if (score > maxValue) {
				maxValue = score;
				maxKey = s;
			}
		}

		System.out.println(maxKey + " " + maxValue);
	}

	private void setString(Iterator<LogFile> it, String key1, String key2) {
		
		do {
			log = it.next();

			string = log.getURL();
			start = string.indexOf(key1);
			end = string.indexOf(key2);

		} while (start != -1 || end != -1);
		
		string = string.substring(start + 7, end);
	}
	
	private void setHashMap(String string, Map<String, Integer> hashMap) {

		if (hashMap.containsKey(string)) {
			Integer count = hashMap.get(string);
			count++;
			hashMap.put(string, count);
		}
		else {
			hashMap.put(string, 1);
		}
	}
	

}
