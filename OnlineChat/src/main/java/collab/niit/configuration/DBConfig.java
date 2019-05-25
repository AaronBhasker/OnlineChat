package collab.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import collab.niit.model.Blog;
import collab.niit.model.BlogLikes;
import collab.niit.model.Blogcomment;
import collab.niit.model.Friend;
import collab.niit.model.JobApplication;
import collab.niit.model.Jobs;
import collab.niit.model.ProfilePicture;
import collab.niit.model.User;


@Configuration
@EnableTransactionManagement
public class DBConfig {
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		datasource.setUsername("aaron");
		datasource.setPassword("hbhasker");
		return datasource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateproperties = new Properties();
		hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		hibernateproperties.setProperty("hibernate.hbm2ddl.auto","update");
        hibernateproperties.put("hibernate.show_sql", true);
        LocalSessionFactoryBuilder localsessionFactorybuilder=new LocalSessionFactoryBuilder(getDataSource());
        localsessionFactorybuilder.addProperties(hibernateproperties);

        localsessionFactorybuilder.addAnnotatedClass(Blog.class);
        localsessionFactorybuilder.addAnnotatedClass(Blogcomment.class);
        localsessionFactorybuilder.addAnnotatedClass(BlogLikes.class);
        localsessionFactorybuilder.addAnnotatedClass(Jobs.class);
        localsessionFactorybuilder.addAnnotatedClass(User.class);
        localsessionFactorybuilder.addAnnotatedClass(JobApplication.class);
        localsessionFactorybuilder.addAnnotatedClass(Friend.class);
        localsessionFactorybuilder.addAnnotatedClass(ProfilePicture.class);
        
        SessionFactory sessionFactory = localsessionFactorybuilder.buildSessionFactory();


     return sessionFactory;
		
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager hibTransMan()
	{
    	return new HibernateTransactionManager(getSessionFactory());

	}

}
