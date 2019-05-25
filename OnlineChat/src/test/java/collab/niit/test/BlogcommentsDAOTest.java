//package collab.niit.test;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import collab.niit.DAO.BlogcommentsDAO;
//
//import collab.niit.model.Blogcomment;
//
//
//public class BlogcommentsDAOTest {
// static BlogcommentsDAO blogcommentsDAO;
// @BeforeClass
// public static void Initialize()
// {
//		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//		context.scan("collab.niit");
//		context.refresh();
//		blogcommentsDAO=(BlogcommentsDAO)context.getBean("blogcommentsDAO");
//		
// }
// 
// @Test
// public void addBlogcommentsTest()
// {
//	 Blogcomment blogcomments=new Blogcomment();
//	 blogcomments.setBlogcomment_id(1);
//	 blogcomments.setCommenttext("Hello");
//	 blogcomments.setCommentby("Aaron");
//	 blogcomments.setCommentedon("28/07/2018");
//	System.out.println(blogcomments.getBlogcomment_id());
//	 assertTrue("Problem in adding the Blogcomment",blogcommentsDAO.addBlogcommentsItem(blogcomments));
//	 
//	 }
// 
////@Test
//// 
//// public void DeleteBlogcommentsTest()
//// {
////	 Blogcomments blogcomments=blogcommentsDAO.getBlogcomments(1);
////		blogcomments.setComment("");
////		assertTrue("problem in updating Blog", blogcommentsDAO.updateBlogcommentsItem(blogcomments));
//// }
// 
//	
//}
