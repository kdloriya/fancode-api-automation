package com.typicode.fancode.test;
import org.testng.annotations.Test;
import com.typicode.fancode.requests.UserBelongsToFanCodeCity;
import com.typicode.fancode.requests.UsersHavingTodoTasks;

public class TodoTasks {

	@Test
	public static void test() {
	
		UsersHavingTodoTasks tasks = new UsersHavingTodoTasks();
		UserBelongsToFanCodeCity users = new UserBelongsToFanCodeCity();
		
		float actCompletedTasks = tasks.usersWithTodoTasks();
		float expCompletedTasks = users.expPercentage();
		
		if(actCompletedTasks >= expCompletedTasks) {
			System.out.println("We have completed more tasks than expected");	
		} else {
			System.out.println("Completed tasks are below our expectations");
		}
	}

}
