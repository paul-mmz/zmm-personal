package com.paul.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class Aspect implements MethodBeforeAdvice, AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		
	}

}
