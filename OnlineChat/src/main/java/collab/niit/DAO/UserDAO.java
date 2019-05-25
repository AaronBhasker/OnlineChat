package collab.niit.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import collab.niit.model.User;
@Repository("userDAO")

public interface UserDAO {
	public boolean registerUser(User user);
	public boolean modifyUser(User user);
	public User getUser(String username);
	public User validateuser(User u);
}
