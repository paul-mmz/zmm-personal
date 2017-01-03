package com.paul.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class HavePaul {

	@ZMM
	public String people;

	public static void main(String[] args) {
		Class<?> clazz = ZMM.class;

		Annotation[] annotation = clazz.getAnnotations();
		for (Annotation a : annotation) {
			if (a instanceof Paul) {
				System.out.println(((Paul) a).id() + ((Paul) a).name() + ((Paul) a).description());
			}
		}

		clazz = HavePaul.class;

		Field[] fields = clazz.getFields();
		Field ff = null;
		for (Field f : fields) {
			if (f.getName().contains("people")) {
				ff = f;
				break;
			}
		}

		System.out.println(ff.getName());

		annotation = ff.getAnnotations();

		for (Annotation a : annotation) {

			Class<?> c = a.getClass();

			if (c.isAnnotationPresent(Paul.class)) {
				System.out.println(((Paul) a).id() + ((Paul) a).name() + ((Paul) a).description());
			}
		}

	}
}
