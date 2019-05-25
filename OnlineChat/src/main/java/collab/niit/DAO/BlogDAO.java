package collab.niit.DAO;



import java.util.List;

import org.springframework.stereotype.Repository;

import collab.niit.model.Blog;
@Repository("blogDAO")
public interface BlogDAO {
	public boolean addBlogItem(Blog blogitem);
	public boolean deleteBlogItem(Blog blogitem);
	public boolean updateBlogItem(Blog blogitem);
	public Blog getBlogItem(int blogItemId);
	public List<Blog> listBlog();
}
