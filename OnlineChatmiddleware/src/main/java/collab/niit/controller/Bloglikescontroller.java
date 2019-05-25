package collab.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import collab.niit.DAO.BlogLikesDAO;
import collab.niit.DAO.UserDAO;
import collab.niit.model.Blog;
import collab.niit.model.BlogLikes;
import collab.niit.model.User;
@Controller
public class Bloglikescontroller {
	
		@Autowired
		private BlogLikesDAO bloglikesDao;
		@Autowired
		UserDAO userDAO;

		@RequestMapping(value = "/hasuserlikedblog/{blogId}", method = RequestMethod.GET)
		public ResponseEntity<?> hasUserLikedBlog(@PathVariable int blogId, HttpSession session) {
			String email= (String)  session.getAttribute("loggedInUser");
			User user=userDAO.getUser(email);
			if (user == null) {
				//ErrorClass error = new ErrorClass(5, "Unauthorized access...");
				return new ResponseEntity<String>("Unauthorized access...", HttpStatus.UNAUTHORIZED);
			}
			BlogLikes blogPostLikes = bloglikesDao.hasUserLikedBlog(blogId, user.getEmailId());
			return new ResponseEntity<BlogLikes>(blogPostLikes, HttpStatus.OK);
		}

		@RequestMapping(value = "/updatelikes/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> updateLikes(@PathVariable int id, HttpSession session) {
			String email= (String)  session.getAttribute("loggedInUser");
			User user=userDAO.getUser(email);
			if (user == null) {
				//ErrorClass error = new ErrorClass(5, "Unauthorised access...");
				return new ResponseEntity<String>("Unauthorized access...", HttpStatus.UNAUTHORIZED);
			}
			Blog blogPost = bloglikesDao.updateLikes(id, user.getEmailId());
			System.out.println(user.getEmailId() + " has liked the blog id " + id);
			return new ResponseEntity<Blog>(blogPost, HttpStatus.OK);
		}

	}


