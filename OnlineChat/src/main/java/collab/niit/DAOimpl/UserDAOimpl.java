package collab.niit.DAOimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collab.niit.DAO.UserDAO;
import collab.niit.model.Jobs;
import collab.niit.model.User;
@Repository("userDAO")
@Transactional
class UserDAOimpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean registerUser(User user) {
sessionFactory.getCurrentSession().save(user);
		
		return true;
	}

	@Override
	public boolean modifyUser(User user) {
		sessionFactory.getCurrentSession().update(user);		
		return true;
	}

	@Override
	public User getUser(String username) {
		try {
			User u=(User) sessionFactory.getCurrentSession().get(User.class, username);
			System.out.println(u.toString());
			return u;
			}
			catch(Exception e)
		{
				return null;
			}
	}

	@Override
	public User validateuser(User u) {
		System.out.println("in dao "+u.getEmailId()+ " "+u.getPassword());
		List<User> ulist=sessionFactory.getCurrentSession().createQuery("from User where emailId='"+u.getEmailId()+"' and password='"+u.getPassword()+"'").list();
		return ulist.get(0);
	}
	
}