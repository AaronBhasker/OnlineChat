package collab.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class JobApplication {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int appid;
	@ManyToOne
	Jobs job;
	@ManyToOne
	User user;
	Date appdate;
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	
	public Jobs getJob() {
		return job;
	}
	public void setJob(Jobs job) {
		this.job = job;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getAppdate() {
		return appdate;
	}
	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}
	
}
