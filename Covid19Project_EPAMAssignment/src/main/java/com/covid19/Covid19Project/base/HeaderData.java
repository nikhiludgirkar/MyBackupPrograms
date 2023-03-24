package com.covid19.Covid19Project.base;

import java.util.HashMap;

public class HeaderData {
	private static HashMap<String, String> map;
	public static HashMap<String, String> getHeaderData(){
		map=new HashMap<String, String>();
		map.put("accept", "application/json");
		return map;
	}
}
