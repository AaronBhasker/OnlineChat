package collab.niit.DAOimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import collab.niit.DAO.JobApplicationDAO;
import collab.niit.model.JobApplication;
import collab.niit.model.Jobs;

@Repository("jobApplicationDAO")
@Transactional
public class JobApplicationDAOimpl implements JobApplicationDAO{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	
	public boolean addJobApplication(JobApplication jobApplicationItem) {
		System.out.println(jobApplicationItem.getAppid());
		sessionFactory.getCurrentSession().save(jobApplicationItem);
		
		return true;
	}

	@Override
	public List<JobApplication> retrieveJobApplications(int jobid) {
		List<JobApplication> jobappsList=sessionFactory.getCurrentSession().createQuery("from JobApplication where job.jobid="+jobid).list();	
		return jobappsList;
	}
	
	
}
