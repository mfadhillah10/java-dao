package com.sti.bootcamp.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sti.bootcamp.dao.impl.CustomerDaoImpl;
import com.sti.bootcamp.dao.interfc.CustomerDao;

@Configuration
public class DaoSpringConfig {
	
	@Bean
	public CustomerDao customerDao() {
		
		return new CustomerDaoImpl();
	}

}
