package com.typicode.fancode.requests;

import java.util.ArrayList;
import com.typicode.fancode.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UsersHavingTodoTasks extends BaseClass {
	
	float userCompletedTasks;
	
	public float usersWithTodoTasks() {
		UserBelongsToFanCodeCity fanCode = new UserBelongsToFanCodeCity();
		ArrayList<Integer> ids = fanCode.fanCodeCityUser();
		
		String todoString = todos();
		Response res =  RestAssured.get(todoString);
		JsonPath jsonData = res.jsonPath();
		int totalFanCodeUsers = ids.size();
		
		for(int id : ids) {
			String taskStatus = jsonData.getString("[" + id + "].completed");
			
			if(taskStatus.equals("true")) {
				userCompletedTasks++;
			}			
		}

		System.out.println("User having completed tasks : " + (int)userCompletedTasks + " out of " + totalFanCodeUsers);
		System.out.println();
		float completedTaskPer = (float)((userCompletedTasks * 100)/totalFanCodeUsers);
		return completedTaskPer;
		
	}

}
