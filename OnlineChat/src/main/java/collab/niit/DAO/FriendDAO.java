package collab.niit.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import collab.niit.model.Friend;
import collab.niit.model.User;

@Repository("friendDAO")
public interface FriendDAO {

	public boolean addFriend(Friend friend);
	public boolean acceptRequest(Friend friend);
	public List<User> getallUsers(String emailid);
	public List<Friend> pendingRequests(char status,String email);
	public List<Friend> Friends(String email);
	public boolean rejectRequest(Friend friend);
}
