package com.taxApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class appWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {appRootConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {appWebConfig.class} ;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
	  

}
