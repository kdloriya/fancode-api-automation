package com.typicode.fancode.requests;

import java.util.ArrayList;
import java.util.List;

import com.typicode.fancode.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class UserBelongsToFanCodeCity extends BaseClass {
	
	public UserBelongsToFanCodeCity() {
		super();
	}
	
	public ArrayList<Integer> fanCodeCityUser() {
	String userString = users();
	Response res =  RestAssured.get(userString);
	JsonPath jsonData = res.jsonPath();
	
	List<Object> users = jsonData.getList("$");
	ArrayList<Integer> fanCodeCityUsers = new ArrayList<>();
	
	for (int i = 0; i < users.size(); i++) {
		 String latStr = jsonData.getString("["+ i +"].address.geo.lat");
		 String lngStr = jsonData.getString("["+ i +"].address.geo.lng");
		 
		 double lat = Double.parseDouble(latStr);
		 double lng = Double.parseDouble(lngStr);
		 
		 if((lat >= minLat() && lat <= maxLat()) && (lng >= minLng() && lng <= maxLng())) {
			 
			 String idString = jsonData.getString("["+ i +"].id");
			 fanCodeCityUsers.add(Integer.parseInt(idString));
		 }
	}
	System.out.println();
	System.out.println("User belonging to the city: " + fanCodeCityUsers.size());
	return fanCodeCityUsers;
	
	}
}

