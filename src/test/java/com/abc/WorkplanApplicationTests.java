package com.abc;

import com.abc.domain.User;
import com.abc.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkplanApplicationTests {

	@Autowired
	private IUserService userService;

	@Test
	public void contextLoads() {

		User user = new User();

		user.setUserId("1");
		userService.userTest(user);
	}

}

