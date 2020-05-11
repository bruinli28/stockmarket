package com.iiht.stock.conf;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**");
            }

			public void configurePathMatch(PathMatchConfigurer configurer) {
				// TODO Auto-generated method stub
				
			}

			public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
				// TODO Auto-generated method stub
				
			}

			public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
				// TODO Auto-generated method stub
				
			}

			public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
				// TODO Auto-generated method stub
				
			}

			public void addFormatters(FormatterRegistry registry) {
				// TODO Auto-generated method stub
				
			}

			public void addInterceptors(InterceptorRegistry registry) {
				// TODO Auto-generated method stub
				
			}

			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				// TODO Auto-generated method stub
				
			}

			public void addViewControllers(ViewControllerRegistry registry) {
				// TODO Auto-generated method stub
				
			}

			public void configureViewResolvers(ViewResolverRegistry registry) {
				// TODO Auto-generated method stub
				
			}

			public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
				// TODO Auto-generated method stub
				
			}

			public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
				// TODO Auto-generated method stub
				
			}

			public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
				// TODO Auto-generated method stub
				
			}

			public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
				// TODO Auto-generated method stub
				
			}

			public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
				// TODO Auto-generated method stub
				
			}

			public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
				// TODO Auto-generated method stub
				
			}

			public Validator getValidator() {
				// TODO Auto-generated method stub
				return null;
			}

			public MessageCodesResolver getMessageCodesResolver() {
				// TODO Auto-generated method stub
				return null;
			}
        };
    }
}
