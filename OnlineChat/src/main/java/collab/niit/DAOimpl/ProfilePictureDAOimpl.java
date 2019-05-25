package collab.niit.DAOimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collab.niit.DAO.ProfilePictureDao;
import collab.niit.model.ProfilePicture;
@Repository("profilepictureDao")
@Transactional
public class ProfilePictureDAOimpl implements ProfilePictureDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void uploadProfilePicture(ProfilePicture profilePicture) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);

	}

	public ProfilePicture getProfilePicture(String email) {
		Session session = sessionFactory.getCurrentSession();
		ProfilePicture profilePicture = (ProfilePicture) session.get(ProfilePicture.class, email);
		System.out.println("DAO " + email + " " + profilePicture);
		return profilePicture;
	}

}
