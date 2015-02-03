package com.maple.log;

import java.util.*;

public class URL {	

	String string;	
	Map<String, Integer> hashMap = new HashMap<String, Integer>();
	int start,end;
	


	
	public void print(Vector<LogFile> logVector) {

		Iterator<LogFile> it = logVector.iterator();
		
		LogFile log = it.next();
		
		string = log.getURL();
		start = string.indexOf("search/");		
		end = string.indexOf("?");
		if(end != -1) {
		string = string.substring(start+7,end);
		}	
		
		hashMap.put(string, 1);
		
		while (it.hasNext()) {
			log = it.next();

			if (log != null) {

				string = log.getURL();
				start = string.indexOf("search/");		
				end = string.indexOf("?");
				
				if (end != -1) {
					string = string.substring(start + 7, end);
					setHashMap(string, hashMap);
				}
			}
		}
		
		Set<String> keySet = hashMap.keySet();
		int maxValue=0; String maxKey = null;
		

		List<Integer> strList = new ArrayList<Integer>();
		
		for(String s : keySet) {
			Integer score = hashMap.get(s);
			strList.add(score);
		}
		
		Collections.sort(strList);
		Collections.reverse(strList);
		
		for(String s : keySet) {
			Integer score = hashMap.get(s);
			if(score==strList.get(2)) { 
				maxKey = s;
			}
		}
		
		System.out.println(maxKey + strList.get(2));
	
		
		
	}
	


	
	public void print2(Vector<LogFile> logVector) {

		Iterator<LogFile> it = logVector.iterator();
		
		LogFile log = it.next();
		
		string = log.getURL();
		start = string.indexOf("apikey=");
		end = string.indexOf("&");
		
		if(start != -1) {
		string = string.substring(start+7,end-1);
		}	
		
		hashMap.put(string, 1);
		
		while (it.hasNext()) {
			log = it.next();

			if (log != null) {

				string = log.getURL();
				start = string.indexOf("apikey=");
				end = string.indexOf("&");
		
				if (start != -1) {
					string = string.substring(start + 7, end-1);
					setHashMap(string, hashMap);			
				}
			}

		}
		
		searchMaxApikey();
		
	}




	private void searchMaxApikey() {
		Set<String> keySet = hashMap.keySet();
		int maxValue=0; String maxKey = null;
		
		for(String s : keySet) {
			Integer score = hashMap.get(s);
			if(score>maxValue) { 
				maxValue = score;
				maxKey = s;
			}
		}
		
		System.out.println(maxKey + " " + maxValue);

/*	
	for (String o : keySet) {
	    if (hashMap.get(o).equals(836)) {
	      maxKey = o;
	    }
	  }
	
	System.out.println(maxKey);
*/
	}	
	




	private void setHashMap(String string, Map<String, Integer> hashMap) {
		if (hashMap.containsKey(string)) { //이미 존재하는 값이면? ++해서 다시풋.
			
			Integer score = hashMap.get(string);					
			score++;
			hashMap.put(string, score);
		}

		else { //존재하지 않는 값이면 풋.
			hashMap.put(string, 1);
		}
	}
	
}
