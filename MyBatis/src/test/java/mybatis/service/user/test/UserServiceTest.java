package mybatis.service.user.test;

import java.util.ArrayList;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;
import mybatis.service.user.UserDao;
import mybatis.service.user.UserService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * FileName : MyBatisTestApp14.java
  * :: Business Layer unit Test : Service + Persistence (Spring +mybatis + DAO)
  * ::  Annotation 기반 
  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= { "classpath:config/commonservice14.xml"})
public class UserServiceTest {
	
	@Autowired
	@Qualifier("userServiceImpl14")
	private UserService userService;
	
	@Autowired
	@Qualifier("userDaoImpl14")
	private UserDao userDao;
	
	@Test
	public void testAddUser() throws Exception
	{
		System.out.println("===============================");
		User user = new User("user04", "주몽", "user04", null, 0);
		System.out.println("insert 결과 : " + userService.addUser(user));
		System.out.println("delete 결과 : " + userDao.removeUser(user.getUserId()));
		
		Assert.assertEquals(1, userService.addUser(user));
		//Assert.assertEquals(0, userService.addUser(user));
		Assert.assertEquals(1, userService.removeUser(user.getUserId()));
	}
	
	@Test
	public void testGetUser() throws Exception
	{
		System.out.println("\n\n===============================");
		User user = userService.getUser("user01");
		System.out.println(user);
		
		Assert.assertEquals("user01", user.getUserId());
		//Assert.assertEquals("user0", user.getUserId());
		Assert.assertNotNull(userService.getUser("user02"));
		//Assert.assertNotNull(userService.getUser("user05"));
	}
	
	

}//end of class