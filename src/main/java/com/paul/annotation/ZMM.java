package com.paul.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Paul(id = 4143, name = "paul", description = "this is from annotation @Paul")
public @interface ZMM {
	public String value() default "zmm";
}
