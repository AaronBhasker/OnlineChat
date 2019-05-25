package collab.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import collab.niit.DAO.UserDAO;

import collab.niit.model.User;

@Controller
public class Usercontroller {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public ResponseEntity<?> adduser(@RequestBody User u)
	{
	System.out.println(u.getEmailId());
		if(u!=null)
		{
		userDAO.registerUser(u);
		return new ResponseEntity<User>(u, HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("User deatils are empty",HttpStatus.NOT_FOUND);
		
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> Validating(@RequestBody User u,HttpSession session)
	{
		System.out.println(u.getEmailId()+" "+u.getPassword());
		User Validuser=userDAO.validateuser(u);
		if(Validuser!=null)
		{
			Validuser.setStatus(true);
			System.out.println(Validuser.toString());
			userDAO.modifyUser(Validuser);
			session.setAttribute("loggedInUser", Validuser.getEmailId());
			System.out.println(session.getAttribute("loggedInUser").toString());
		return new ResponseEntity<User>(Validuser, HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Incorrect username or password",HttpStatus.NOT_FOUND);
			
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ResponseEntity<?> signingout(HttpSession session)
	{
		System.out.println("logging out");
		String email=(String) session.getAttribute("loggedInUser");
		User user=userDAO.getUser(email);
		System.out.println(session.getAttribute("loggedInUser"));
		if(session.getAttribute("loggedInUser")!=null)
		{
			System.out.println(email.toString());
		user.setStatus(false);
		userDAO.modifyUser(user);
		session.removeAttribute("loggedInUser");
		session.invalidate();
		return new ResponseEntity<String>("successfully logged out",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Login",HttpStatus.NOT_FOUND);
	}
}
