package com.paul.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paul.spring.configs.BeanWayService;
import com.paul.spring.configs.ConfigBeanWithMain;

@ContextConfiguration(classes = {ConfigBeanWithMain.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class DemoSpringTests {
	
	@Autowired
	private BeanWayService bean;
	
	@Test
	public void testProfile(){
		System.out.println(bean.getContent());
	}
}
