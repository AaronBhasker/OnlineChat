package collab.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import collab.niit.DAO.BlogDAO;
import collab.niit.DAO.BlogcommentsDAO;
import collab.niit.DAO.UserDAO;
import collab.niit.model.Blog;
import collab.niit.model.Blogcomment;
import collab.niit.model.User;

@Controller
public class Blogcommentscontroller {
	@Autowired
	BlogcommentsDAO blogcommentsDAO;
	@Autowired
	BlogDAO blogDAO;
	@Autowired
	UserDAO userDAO;
	@RequestMapping(value="/addblogComment/{id}",method=RequestMethod.POST)
	public ResponseEntity<?> addblog(@RequestBody Blogcomment bc,@PathVariable("id") int id,HttpSession session)
	{
		String email= (String) session.getAttribute("loggedInUser");
		User user=userDAO.getUser(email);
		Blog blog=blogDAO.getBlogItem(id);
		if(bc!=null&&email!=null)
		{
			
			bc.setBlog(blog);
			bc.setCommentedon(new Date());
			bc.setCommentby(user);
		blogcommentsDAO.addBlogcommentsItem(bc);
		return new ResponseEntity<Blogcomment>(bc, HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("blogcomment deatils are empty",HttpStatus.NOT_FOUND);
		
	}
	
	
	@RequestMapping(value="/ListBlogComments/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> listBlogCommets(@PathVariable("id") int id)
	{
		List<Blogcomment> blogCommentsList= blogcommentsDAO.retrieveBlogcommentsItem(id);
		return new ResponseEntity<List<Blogcomment>>(blogCommentsList, HttpStatus.OK);
	}
}
