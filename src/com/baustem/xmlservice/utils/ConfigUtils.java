package com.baustem.xmlservice.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	
	public static String getXmlPath(){
		String xmlPath = "";
		Properties prop = new Properties();
		try {
			prop.load(ConfigUtils.class.getResourceAsStream("/xmlservice.properties"));
			
			xmlPath = prop.getProperty("xmlPath");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return xmlPath;
		
		
	}
	
}
