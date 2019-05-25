package collab.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class BlogLikes {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
int likeid;
@ManyToOne
private Blog blog;
@OneToOne
User user;

public int getLikeid() {
	return likeid;
}
public void setLikeid(int likeid) {
	this.likeid = likeid;
}

public Blog getBlog() {
	return blog;
}
public void setBlog(Blog blog) {
	this.blog = blog;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
}
