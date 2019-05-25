package collab.niit.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import collab.niit.model.Blogcomment;


@Repository("blogcommentsDAO")
public interface BlogcommentsDAO {
 public boolean addBlogcommentsItem(Blogcomment blogcommentsItem);
 public boolean deleteBlogcommentsItem(Blogcomment blogcommentsItem);
 public boolean updateBlogcommentsItem(Blogcomment blogcommentsitem);
 public List<Blogcomment> retrieveBlogcommentsItem(int blogid);

 

}
	