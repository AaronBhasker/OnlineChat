package collab.niit.controller;

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

import collab.niit.DAO.FriendDAO;
import collab.niit.DAO.UserDAO;
import collab.niit.model.Friend;
import collab.niit.model.User;


@Controller
public class Friendcontroller {
	@Autowired
	FriendDAO friendDAO;
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/addFriend",method=RequestMethod.POST)
	public ResponseEntity<?> addfriend(@RequestBody String friendemail,HttpSession session)
	{
		String email=(String) session.getAttribute("loggedInUser");
		User fromId=userDAO.getUser(email);
		User toId=userDAO.getUser(friendemail);
			Friend f=new Friend();
			f.setFromId(fromId);
			f.setToId(toId);
			f.setStatus('p');
			System.out.println(f.getFriendId());
		friendDAO.addFriend(f);
		
		
		return new ResponseEntity<Friend>(f, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/updateFriend/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?> updatefriend(@PathVariable("id") int id,@RequestBody Friend friend)
	{
		
		
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/listFriends",method=RequestMethod.GET)
	public ResponseEntity<?> listfriends(HttpSession session)
	{
		String email = (String) session.getAttribute("loggedInUser");
		List<User> listfriends=friendDAO.getallUsers(email);
		return new ResponseEntity<List<User>>(listfriends,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/pendingRequests",method=RequestMethod.GET)
	public ResponseEntity<?> pendingRequests(HttpSession session)
	{
		String email = (String) session.getAttribute("loggedInUser");
		List<Friend> pendingRequests=friendDAO.pendingRequests('p',email);
		
		return new ResponseEntity<List<Friend>>(pendingRequests,HttpStatus.OK);
		
	} 
	
	@RequestMapping(value="/acceptRequest",method=RequestMethod.PUT)
	public ResponseEntity<?> acceptRequest(@RequestBody Friend friend,HttpSession session)
	{
		friendDAO.acceptRequest(friend);
		
		return new ResponseEntity<Friend>(HttpStatus.OK);	
		
	}
	
	@RequestMapping(value="/FriendsList",method=RequestMethod.GET)
	public ResponseEntity<?> Friends(HttpSession session)
	{
		String email = (String) session.getAttribute("loggedInUser");
		List<Friend> friendslist=friendDAO.Friends(email);
		return new ResponseEntity<List<Friend>>(friendslist,HttpStatus.OK);
		
		
}
	
	
	
	@RequestMapping(value="/rejectRequest",method=RequestMethod.DELETE)
	public ResponseEntity<?> rejectRequest(@RequestBody Friend friend,HttpSession session)
	{
		friendDAO.rejectRequest(friend);
		
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);	
		
	}

}