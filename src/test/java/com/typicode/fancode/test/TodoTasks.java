package com.typicode.fancode.test;
import org.testng.Assert;
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
		boolean result;
		
		if(actCompletedTasks >= expCompletedTasks) {
			System.out.println("Completed tasks are as per our expectations.");	
			System.out.println(actCompletedTasks + "% of tasks are completed.");
			result = true;
		} else {
			System.err.println("Completed tasks are not as per our expectations.");
			System.err.println(actCompletedTasks + "% tasks are completed.");
			result = false;
		}
		Assert.assertTrue(result);
	}

}
