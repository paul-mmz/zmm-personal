package com.paul.spring.configs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service
public class JSRWayService {
	public JSRWayService(){
		System.out.println("constructor JSRWayService()");
	}

	@PostConstruct
	public void init() {
		System.out.println("init()");
	}

	@PreDestroy
	public void destory() {
		System.out.println("destory()");
	}
}
