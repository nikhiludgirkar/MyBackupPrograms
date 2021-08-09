package com.shaadi.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public static Properties prop;
	public static File file;
	public static FileReader reader;
	public static Properties readProperties() throws IOException {
		file=new File("././configurations/browser.properties");
		reader=new FileReader(file);
		prop=new Properties();
		prop.load(reader);
		return prop;
	}

}
