package collab.niit.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import collab.niit.model.Jobs;

@Repository("jobsDAO")
@Transactional
public interface JobsDAO {
	public boolean addJobsItem(Jobs jobItem);
	public boolean deleteJobsItem(Jobs jobsItem);
	public boolean updateJobsItem(Jobs jobsItem);
	public List<Jobs> retrieveJobsItem();
	public Jobs getJobsItem(int jobsItemId);
	
	
	

}
