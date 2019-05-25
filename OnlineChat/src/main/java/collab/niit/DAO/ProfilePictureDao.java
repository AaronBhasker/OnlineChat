package collab.niit.DAO;

import org.springframework.stereotype.Repository;

import collab.niit.model.ProfilePicture;



@Repository("profilepictureDao")
public interface ProfilePictureDao {
	void uploadProfilePicture(ProfilePicture profilePicture);

	ProfilePicture getProfilePicture(String email);

}