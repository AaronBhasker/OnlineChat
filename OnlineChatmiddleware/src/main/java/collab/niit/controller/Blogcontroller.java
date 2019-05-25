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
public class Blogcontroller {
	@Autowired
	BlogDAO blogDAO;
	@Autowired
	UserDAO userDAO;
	@RequestMapping(value="/addBlog",method=RequestMethod.POST)
	public ResponseEntity<?> addblog(@RequestBody Blog b,HttpSession session)
	{
		String email= (String)  session.getAttribute("loggedInUser");
		User user=userDAO.getUser(email);
		if(b!=null)
		{
			
			b.setPostedon(new Date());
			b.setUser(user);
		blogDAO.addBlogItem(b);
		return new ResponseEntity<Blog>(b, HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("blog deatils are empty",HttpStatus.NOT_FOUND);
		
	}
		@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
		public ResponseEntity<?> deleteblog(@PathVariable("id") int id)
		
		{
			Blog b=blogDAO.getBlogItem( id);
			blogDAO.deleteBlogItem(b);
			
			if(b!=null)
			{
			blogDAO.deleteBlogItem(b);
			return new ResponseEntity<Blog>(b, HttpStatus.OK);
			}
			else
				return new ResponseEntity<String>("blog not found",HttpStatus.NOT_FOUND);
			
		}
@RequestMapping(value="/ListBlog",method=RequestMethod.GET)
public ResponseEntity<?> listBlog()
{
	List<Blog> blogList= blogDAO.listBlog();
	return new ResponseEntity<List<Blog>>(blogList, HttpStatus.OK);
}

@RequestMapping(value="/GetBlog/{id}",method=RequestMethod.GET)
public ResponseEntity<?> getblog(@PathVariable("id") int id) 
{

	Blog blogList= blogDAO.getBlogItem(id);
	return new ResponseEntity<Blog>(blogList, HttpStatus.OK);

}


}
