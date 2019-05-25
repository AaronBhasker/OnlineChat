package collab.niit.controller;



import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import collab.niit.DAO.JobApplicationDAO;
import collab.niit.DAO.JobsDAO;
import collab.niit.DAO.UserDAO;
import collab.niit.model.Blog;
import collab.niit.model.JobApplication;
import collab.niit.model.Jobs;
import collab.niit.model.User;


@Controller
public class Jobcontroller {
	
	@Autowired
JobsDAO jobsDAO;
	@Autowired
	UserDAO userDAO;
@Autowired
JobApplicationDAO jobApplicationDAO;


@RequestMapping(value="/addJobs",method=RequestMethod.POST)
public ResponseEntity<?> addjob(@RequestBody Jobs j)
{

	if(j!=null)
	{
		System.out.println(j.getJobid());
	jobsDAO.addJobsItem(j);
	return new ResponseEntity<Jobs>(j, HttpStatus.OK);
	}
	else
		return new ResponseEntity<String>("job deatils are empty",HttpStatus.NOT_FOUND);
	
}

@RequestMapping(value="/deleteJobs/{id}",method=RequestMethod.DELETE)
public ResponseEntity<?> deletejob(@PathVariable("id") int id)
{
	Jobs j=jobsDAO.getJobsItem(id);
	jobsDAO.deleteJobsItem(j);
	
	if(j!=null)
	{
	jobsDAO.deleteJobsItem(j);
	return new ResponseEntity<Jobs>(j, HttpStatus.OK);
	}
	else
		return new ResponseEntity<String>("job deatils are empty",HttpStatus.NOT_FOUND);
	
}
@RequestMapping(value="/listJobs",method=RequestMethod.GET)
public ResponseEntity<?> listjobs()
{
	List<Jobs> jobList=jobsDAO.retrieveJobsItem();
	return new ResponseEntity<List<Jobs>>(jobList,HttpStatus.OK);
	
}

@RequestMapping(value="/updateJobs/{id}",method=RequestMethod.PUT)
public ResponseEntity<?> updatejob(@PathVariable("id") int id,@RequestBody Jobs job)
{
	String s=job.getExperience();
	Jobs j=jobsDAO.getJobsItem(id);
	j.setExperience(s);
	jobsDAO.updateJobsItem(j);
	return new ResponseEntity<Jobs>(j,HttpStatus.OK);
	
}

@RequestMapping(value="/addJobApplication",method=RequestMethod.POST)
public ResponseEntity<?> addjobAppplication(@RequestBody JobApplication k,HttpSession session)
{
	String email= (String) session.getAttribute("loggedInUser");
	User user=userDAO.getUser(email);
	if(k!=null)
	{
		k.setAppdate(new Date());
		k.setUser(user);
		System.out.println(k.getAppid());
		jobApplicationDAO.addJobApplication(k);
	return new ResponseEntity<JobApplication>(k, HttpStatus.OK);
	}
	else
		return new ResponseEntity<String>("job deatils are empty",HttpStatus.NOT_FOUND);
	
}

@RequestMapping(value="/listJobApplication/{jobid}",method=RequestMethod.GET)
public ResponseEntity<?> listJobApps(@PathVariable("jobid") int jobid)
{
	List<JobApplication> jobApplicationList=jobApplicationDAO.retrieveJobApplications(jobid);
	return new ResponseEntity<List<JobApplication>>(jobApplicationList,HttpStatus.OK);

}
}
	

