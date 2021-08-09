package com.covid19.Covid19Project.base;

import java.util.HashMap;
import java.util.Properties;

public class EnvSpecificData {
	private static HashMap<String, String> map;
	private static Properties prop;
	public static HashMap<String, String> getData(){
		
		map=new HashMap<String, String>();
		prop=new Properties();
		prop=PropertiesReader.getPropertiesData();
		map.put("url", prop.getProperty("url"));
		map.put("statecountbasepath", prop.getProperty("statecountbasepath"));
		map.put("districtwisebasepath", prop.getProperty("districtwisebasepath"));
		return map;
	}
}
