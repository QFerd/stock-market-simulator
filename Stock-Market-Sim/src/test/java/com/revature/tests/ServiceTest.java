package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.models.User;
import com.revature.repository.UserRepositoryImpl;
import com.revature.service.UserServiceImpl;

//public class TestDriver {
//	public static void main(String[] args) {
//		User u = new User("Teach", "tpw", new UserRole(1));
//		UserRepositoryImpl userRepo = new UserRepositoryImpl();
//		userRepo.register(u);
//	}
//}


public class ServiceTest {

	// class to be tested
	private UserServiceImpl userv;

	// dependencies that our service layer needs in order to make contact with DB
	private UserRepositoryImpl uRepo;

	@Before
	public void setup() {
		
		userv = new UserServiceImpl();
		
		// fake database connection & tricking service layer
		uRepo = mock(UserRepositoryImpl.class);
		
		// set the UserRepositoryImpl of the Service to the one that we mocked
//		userv.userRepository = uRepo;
		
	}
		@Test
		public void confirmRegister() {
						
			User sampleUser = new User(1, "mi", "1234", "student", null); 
			
			// create a fake list representing the list of User pull from the DB
			List<User> list = new ArrayList<User>();
			list.add(sampleUser);
			
			when(uRepo.getAllUsers()).thenReturn(list);
			
//			System.out.println(sampleUser.getUsername());
			//System.out.println(userv.getUser(sampleUser.getUsername()));
			User gotUser = uRepo.getAllUsers().get(0);
//			System.out.println(gotUser);
			
			assertEquals(sampleUser, gotUser);

			
	}
}