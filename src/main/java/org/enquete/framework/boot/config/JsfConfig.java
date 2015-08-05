package org.enquete.framework.boot.config;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

@Configuration
public class JsfConfig implements ServletContextAware, ServletContextInitializer {

	@Bean
	public ServletRegistrationBean facesServlet() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean registration = new ServletRegistrationBean(servlet, "*.jsf");
		registration.setName("FacesServlet");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("primefaces.THEME", "casablanca");
//		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
//		servletContext.setInitParameter("primefaces.PUBLIC_CAPTCHA_KEY", "6Lcq0goTAAAAAMMGB4sfVn157Acy9bUA5FmrPECL");
//		servletContext.setInitParameter("primefaces.PRIVATE_CAPTCHA_KEY", "6Lcq0goTAAAAAKOxVyBOdRfZRcUSM23aFJtP13MX");
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
	}
}
