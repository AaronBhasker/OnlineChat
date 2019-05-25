package collab.niit.DAOimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collab.niit.DAO.BlogDAO;
import collab.niit.model.Blog;
@Repository("blogDAO")
@Transactional
public class BlogDAOimpl implements BlogDAO
{
@Autowired
SessionFactory sessionFactory;
	public boolean addBlogItem(Blog blogitem) {
		sessionFactory.getCurrentSession().save(blogitem);
		return true;
	}

	public boolean deleteBlogItem(Blog blogitem) {
		try
		{
		sessionFactory.getCurrentSession().delete(blogitem);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateBlogItem(Blog blogitem) {
		sessionFactory.getCurrentSession().update(blogitem);
		return false;
	}

	

	public Blog getBlogItem(int blogItemId) {
		try {
		Blog b=(Blog) sessionFactory.getCurrentSession().get(Blog.class, blogItemId);
		return b;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public List<Blog> listBlog() {
		List<Blog> bloglist=sessionFactory.getCurrentSession().createQuery("from Blog").list();
		return bloglist;
	}
  
}
