//package collab.niit.test;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.List;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//
//import collab.niit.DAO.JobsDAO;
//import collab.niit.model.Jobs;
//
//
//public class JobDAOTest {
//	static JobsDAO jobsDAO;
//	
//	@BeforeClass
//	
//	public static void Initialize()
//	{
//		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//		context.scan("collab.niit");
//		context.refresh();
//		jobsDAO=(JobsDAO)context.getBean("jobsDAO");
//	}	
//
//	@Test
//	public void addjobTest()
//	{
//	Jobs jobs=new Jobs();	
//	jobs.setExperience("5 years ");
//	jobs.setJobtitle("Teacher ");
//	jobs.setLastdate("28/07/2019 ");
//	jobs.setQualification("MBA ");
//	jobs.setSalary("50,000");
//	jobs.setSkillsrequired("computer knowledge");
//	   assertTrue("Problem in adding the job",jobsDAO.addJobsItem(jobs));
//	   
//	   
//	
//	}
//	@Test
//	public void deletejobTest()
//	{
//		Jobs job=jobsDAO.getJobsItem(1);
//		 assertTrue("the removed job is as follows",jobsDAO.deleteJobsItem(job));
//				
//	}
//	
//	@Test
//	public void  updatejobTest()
//	{
//		Jobs job=jobsDAO.getJobsItem(0);
//		job.setSalary("60,000");
//		 assertTrue("the udated job is as follows",jobsDAO.updateJobsItem(job));
//	}
//	
//	@Test
//	public void ListjobTest()
//	{
//		List<Jobs> jobs=jobsDAO.retrieveJobsItem("Bhasker");
//		assertNotNull("jobs are exist", jobs);
//		for(Jobs job:jobs)
//		{
//			System.out.println("Jobs Id:"+job.getJobid());
//			System.out.println("Jobs Name:"+job.getJobtitle());
//		}
//	}
//	
//	
//}
