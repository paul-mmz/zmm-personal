package com.paul.annotation;

import java.lang.reflect.Field;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Resources(value = { @Resource(name = ""), @Resource(name = "123") })
@Controller
@Component
@Service
@Repository
@Transactional
@RequestMapping
@Qualifier("zmm")
public class PaulHandler {

	@Paul(id = 1, name = "zmm", description = "human")
	String field;

	public static void handlePaulAnnotation(@RequestParam(required=false ) Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(Paul.class)) {
				Paul p = f.getAnnotation(Paul.class);
				System.out.println(p.id() + ", " + p.name() + ", " + p.description());
			}
		}
	}

	@PostConstruct
	@PreDestroy
	@Required
	public static void main(String[] args) {
		handlePaulAnnotation(PaulHandler.class);

	}

}
