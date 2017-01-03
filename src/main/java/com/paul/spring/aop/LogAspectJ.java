package com.paul.spring.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspectJ {

	@Pointcut("@annotation(com.paul.spring.aop.Action)")
	public void annotationPointcut() {};

	@Pointcut("execution(* com.paul.spring.aop.DemoMethodService.*(..))")
	public void methodPointcut() {};

	@After("annotationPointcut()")
	public void after(JoinPoint jointPoint) {
		MethodSignature signature = (MethodSignature) jointPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("annotation intercepter, in " + action.value());
	}

	@Before("methodPointcut()")
	public void before(JoinPoint jointPoint) {
		MethodSignature signature = (MethodSignature) jointPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("method intercepter, in method " + method.getName());
	}

}
