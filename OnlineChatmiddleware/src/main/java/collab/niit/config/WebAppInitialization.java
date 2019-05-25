package collab.niit.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import collab.niit.configuration.DBConfig;

public class WebAppInitialization extends AbstractAnnotationConfigDispatcherServletInitializer
{
	public WebAppInitialization() {
		System.out.println("hi");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebAppconfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DBConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("inside");
		return new String[] { "/" };
	}
}

