package collab.niit.DAOimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import collab.niit.DAO.JobsDAO;
import collab.niit.model.Blog;
import collab.niit.model.Jobs;
@Repository("jobsDAO")
@Transactional
public class JobsDAOimpl implements JobsDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean addJobsItem(Jobs jobItem) {
		System.out.println(jobItem.getJobid());
		sessionFactory.getCurrentSession().save(jobItem);
		
		return true;
		}

	public boolean deleteJobsItem(Jobs jobsItem) {
		try
		{
		sessionFactory.getCurrentSession().delete(jobsItem);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
		

	public boolean updateJobsItem(Jobs jobsItem) {
		sessionFactory.getCurrentSession().update(jobsItem);		
		return true;
	}

	public List<Jobs> retrieveJobsItem() {
			
		List<Jobs> jobsList=sessionFactory.getCurrentSession().createQuery("from Jobs").list();
		
		return jobsList;
	}

	public Jobs getJobsItem(int jobsItemId) {
		try {
			Jobs j=(Jobs) sessionFactory.getCurrentSession().get(Jobs.class, jobsItemId);
			return j;
			}
			catch(Exception e)
		{
				return null;
			}

	}
	
}
