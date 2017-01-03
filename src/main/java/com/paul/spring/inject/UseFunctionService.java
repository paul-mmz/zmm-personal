package com.paul.spring.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {
	
	@Autowired
	FunctionService function;
	
	public void setFunctionService(FunctionService functionService){
		this.function = functionService;
	}
	
	public String sayHello(String word){
		return function.sayHello(word);
	}
}
