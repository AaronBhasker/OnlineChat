package collab.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Blogcomment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogcomment_id;
	@ManyToOne
	private User commentby;
	@ManyToOne
	private Blog blog;
	private String commenttext;
	private Date commentedon;
	
	public int getBlogcomment_id() {
		return blogcomment_id;
	}
	public void setBlogcomment_id(int blogcomment_id) {
		this.blogcomment_id = blogcomment_id;
	}
	public User getCommentby() {
		return commentby;
	}
	public void setCommentby(User commentby) {
		this.commentby = commentby;
	}
	
	public String getCommenttext() {
		return commenttext;
	}
	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}
	public Date getCommentedon() {
		return commentedon;
	}
	public void setCommentedon(Date commentedon) {
		this.commentedon = commentedon;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	

}
