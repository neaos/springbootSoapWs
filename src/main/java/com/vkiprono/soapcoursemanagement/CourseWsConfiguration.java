package com.vkiprono.soapcoursemanagement;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class CourseWsConfiguration {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {

        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setTransformWsdlLocations(true);
        messageDispatcherServlet.setApplicationContext(context);

        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    @Bean
    XsdSchema coursesSchema(){
        return new  SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
    }
    @Bean(name = "courses")
    public DefaultWsdl11Definition wsdl11Definition(XsdSchema coursesSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setTargetNamespace("http://vkiprono.com/courses");
        definition.setSchema(coursesSchema);
        definition.setLocationUri("/ws");
        definition.setPortTypeName("CoursePort");
        return definition;
    }

}
