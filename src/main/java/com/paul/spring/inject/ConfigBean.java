package com.paul.spring.inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
 @ComponentScan("com.paul.spring")
public class ConfigBean {

	@Bean
	public FunctionService getFunctionService() {
		return new FunctionService();
	}

//	@Bean
//	public UseFunctionService getUseFunctionService() {
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(getFunctionService());
//		return useFunctionService;
//	}
//	
	
//	@Bean
//	public UseFunctionService getUseFunctionService(FunctionService functionService) {
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(functionService);
//		return useFunctionService;
//	}

}
