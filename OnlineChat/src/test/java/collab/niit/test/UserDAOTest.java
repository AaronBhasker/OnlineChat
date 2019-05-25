package collab.niit.test;


import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import collab.niit.DAO.UserDAO;
import collab.niit.model.User;

public class UserDAOTest {
	static UserDAO userDAO;
	@BeforeClass
	public static void Initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("collab.niit");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}	
		
	@Test
	public void registerUserTest()
	{
		User user = new User();
		user.setName("Aaron B");
		user.setEmailId("aronbhasker@gmail.com");
		user.setMobilenumber("9886771386");
		user.setPassword("hbhasker");
		assertTrue("Problem in registering the user",userDAO.registerUser(user));
		
	}
//	@Test
//	public void modifyUserTest()
//	{
//		User user=userDAO.getUser("bhasker@gmail.com");
//		user.setMobilenumber("9487393622");
//		assertTrue("problem in updating the user",userDAO.modifyUser(user));
//	}
//	 public void getUser()
//	    {
//	    	assertTrue("object should be null",userDAO.getUser("Aaron B"));
//	    	User user=userDAO.getUser("Bhasker");
//	    	System.out.println("Username: "+user.getName());
//	    	System.out.println("Password: "+user.getPassword());
//	    	System.out.println("Email Id:"+user.getEmailId());
//	    	System.out.println("Mobile Number: "+user.getMobilenumber());
//	    	
//	    }

}
