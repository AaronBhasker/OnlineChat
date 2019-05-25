package collab.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Jobs {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jobid; 
private String jobtitle;
private String skillsrequired;
private String salary;
private String lastdate;
private String experience;
private String qualification;
public int getJobid() {
	return jobid;
}
public void setJobid(int jobid) {
	this.jobid = jobid;
}
public String getJobtitle() {
	return jobtitle;
}
public void setJobtitle(String jobtitle) {
	this.jobtitle = jobtitle;
}
public String getSkillsrequired() {
	return skillsrequired;
}
public void setSkillsrequired(String skillsrequired) {
	this.skillsrequired = skillsrequired;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getLastdate() {
	return lastdate;
}
public void setLastdate(String lastdate) {
	this.lastdate = lastdate;
}
public String getExperience() {
	return experience;
}
public void setExperience(String experience) {
	this.experience = experience;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}

}
