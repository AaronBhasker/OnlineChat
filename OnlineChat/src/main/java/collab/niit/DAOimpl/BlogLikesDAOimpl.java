package collab.niit.DAOimpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collab.niit.DAO.BlogLikesDAO;
import collab.niit.model.Blog;
import collab.niit.model.BlogLikes;
import collab.niit.model.User;
@Repository("bloglikesDao")
@Transactional
public class BlogLikesDAOimpl implements BlogLikesDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogLikes hasUserLikedBlog(int blogId, String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from BlogLikes where blog.blogId=" + blogId + " and user.emailId='" + email + "'");
		
		
		BlogLikes blogPostLikes = (BlogLikes) query.uniqueResult();
		
		
		return blogPostLikes;

	}
	
	public Blog updateLikes(int id, String email) {
		Session session = sessionFactory.getCurrentSession();
		BlogLikes blogPostLikes = hasUserLikedBlog(id, email);
		Blog blogPost = (Blog) session.get(Blog.class, id);
		if (blogPostLikes == null) {
			blogPostLikes = new BlogLikes();
			User user = (User) session.get(User.class, email);

			blogPostLikes.setBlog(blogPost);
			blogPostLikes.setUser(user);
			session.save(blogPostLikes);
			blogPost.setLikes(blogPost.getLikes() + 1);
			session.update(blogPost);
		} else {
			session.delete(blogPostLikes);
			blogPost.setLikes(blogPost.getLikes() - 1);
			session.update(blogPost);
		}
		return blogPost;
	}

}
