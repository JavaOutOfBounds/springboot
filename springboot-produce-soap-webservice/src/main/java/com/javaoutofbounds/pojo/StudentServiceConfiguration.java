package com.javaoutofbounds.pojo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@EnableWs
@Configuration
public class StudentServiceConfiguration extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		final MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		return new ServletRegistrationBean(servlet, "/student/*");
	}

	@Bean(name = "helloStudent")
	public Wsdl11Definition wsdl11Definition() {

		final SimpleWsdl11Definition simpleWsdl11Definition = new SimpleWsdl11Definition();
		simpleWsdl11Definition.setWsdl(new ClassPathResource("/wsdl/students.wsdl"));
		return simpleWsdl11Definition;
	}
}
