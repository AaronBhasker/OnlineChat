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
//
//import collab.niit.DAO.BlogDAO;
//import collab.niit.model.Blog;
//import jdk.nashorn.internal.ir.annotations.Ignore;
//
//
//
//public class BlogDAOTest {
//	static BlogDAO blogDAO; 
//	 @BeforeClass
//	 public static void Initialize()
//	 {
//	 	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//	 	context.scan("collab.niit");
//	 	context.refresh();
//	 	blogDAO=(BlogDAO)context.getBean("blogDAO");
//	 }
//	 
// @Ignore
// @Test
// public void addblogTest()
//{
//
//	     Blog b=new Blog();
//	     b.setBlogId(2);
//	     b.setTitle("Java");
//	     b.setDescription("Object oriented programming language");
//	     assertTrue("Problem in adding the blog",blogDAO.addBlogItem(b));
//	    
//	 }
//	 @Ignore
//	 @Test
//	 public void deleteblogTest()
//	 {
//	 Blog blog=blogDAO.getBlogItem(1);
//	 assertTrue("the removed blog is as follows",blogDAO.deleteBlogItem(blog));
//	 }
//	 
//	 @Test
//		public void updateBlogTest()
//		{
//			Blog blog=blogDAO.getBlogItem(2);
//			blog.setTitle("Core Java");
//			assertTrue("problem in updating Blog", blogDAO.updateBlogItem(blog));
//		}
//	 
//
//
//
//  @Test
//  public void getBlogByIdTest()
//  {
//	  //Blog blog=BlogDAO.getBlogById(2);
//	  assertNotNull("object shall be null",blogDAO.getBlogItem(2));
//  }
//  
//  @Test
//  public void listBlogTest()
//  {
//	  List<Blog> blogs=blogDAO.listBlog();
//	  assertNotNull("blogs are exist", blogs);
//	  for(Blog blog:blogs)
//	  {
//		  System.out.println("Blog Id"+blog.getBlogId());
//		  System.out.println("Blog Name"+blog.getBlogId());
//	  }
//  }
//}
