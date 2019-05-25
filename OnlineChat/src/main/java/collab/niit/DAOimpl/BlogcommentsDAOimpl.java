package collab.niit.DAOimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collab.niit.DAO.BlogcommentsDAO;
import collab.niit.model.Blog;
import collab.niit.model.Blogcomment;

@Repository("blogcommentsDAO")
@Transactional
public class BlogcommentsDAOimpl implements BlogcommentsDAO
{
@Autowired
SessionFactory sessionFactory;
	public boolean addBlogcommentsItem(Blogcomment blogcommentsItem) {
		sessionFactory.getCurrentSession().save(blogcommentsItem);
		
		return true;
	}

	public boolean deleteBlogcommentsItem(Blogcomment blogcommentsItem) {
		try
		{
		sessionFactory.getCurrentSession().delete(blogcommentsItem);
		return true;
		}
		catch(Exception e)
		{
		
		return false;
	}
	}
	

	@Override
	public boolean updateBlogcommentsItem(Blogcomment blogcommentsitem) {
		
		
		return false;
	}

	@Override
	public List<Blogcomment> retrieveBlogcommentsItem(int blogid) {
	
		List<Blogcomment> blogcommentlist=sessionFactory.getCurrentSession().createQuery("from Blogcomment where blog.blogId="+blogid).list();
		return blogcommentlist;
		
	}

	


}
