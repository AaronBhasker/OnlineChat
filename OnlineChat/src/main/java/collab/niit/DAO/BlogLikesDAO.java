package collab.niit.DAO;

import org.springframework.stereotype.Repository;

import collab.niit.model.Blog;
import collab.niit.model.BlogLikes;


	@Repository("bloglikesDao")
	public interface BlogLikesDAO {
		BlogLikes hasUserLikedBlog(int blogId, String email);

		Blog updateLikes(int id, String email);
	}

