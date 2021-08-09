package com.covid19.Covid19Project.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	private static Properties prop;
	public static Properties getPropertiesData() {
		prop=new Properties();
		try {
			prop.load(new FileReader(new File(System.getProperty("user.dir")+"/configuration/covidapp.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
