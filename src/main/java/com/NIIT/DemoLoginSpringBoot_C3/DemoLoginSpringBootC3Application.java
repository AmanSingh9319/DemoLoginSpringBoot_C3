package com.NIIT.DemoLoginSpringBoot_C3;

import com.NIIT.DemoLoginSpringBoot_C3.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoLoginSpringBootC3Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoLoginSpringBootC3Application.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/api/v1/*");
		return filterRegistrationBean;
	}

}
