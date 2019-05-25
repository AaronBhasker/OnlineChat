package collab.niit.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import collab.niit.model.JobApplication;
import collab.niit.model.Jobs;

@Repository("jobApplicationDAO")

public interface JobApplicationDAO {
public boolean addJobApplication(JobApplication jobApplicationItem);
		public List<JobApplication> retrieveJobApplications(int jobid);
	
}
