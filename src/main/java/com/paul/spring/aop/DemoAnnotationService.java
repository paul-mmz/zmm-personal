package com.paul.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {

	@Action("add")
	public void add() {
		System.out.println("DemoAnnotaionService.add method");
	}
}
