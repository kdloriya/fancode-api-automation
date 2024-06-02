package com.typicode.fancode.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class BaseClass {
	
	static Properties prop;
	
	public BaseClass() {
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/typicode/fancode/properties/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int maxLat() {
		int max_lat = Integer.parseInt(prop.getProperty("max_lat"));
		return max_lat;
	}
	public static int minLat() {
		int min_lat = Integer.parseInt(prop.getProperty("min_lat")); 
		return min_lat;
	}
	public static int maxLng() {
		int max_lng = Integer.parseInt(prop.getProperty("max_lng")); 
		return max_lng;
	}
	public static int minLng() {
		int min_lng = Integer.parseInt(prop.getProperty("min_lng")); 
		return min_lng;
	}
	public static String users() {
		String users = prop.getProperty("users"); 
		return users;
	}
	public static String todos() {
		String todos = prop.getProperty("todos"); 
		return todos;
	}	
	
	public float expPercentage() {
		String userInput = prop.getProperty("expUsersWithCompltedTasks"); 
		float expFloat = 0;
		String[] expPer = userInput.split("%");
		for(String exp : expPer) {
			expFloat = Float.parseFloat(exp);
		}
		return expFloat;
	}	
}

