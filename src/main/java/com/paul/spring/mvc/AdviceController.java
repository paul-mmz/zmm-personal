package com.paul.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {

	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {
		throw new IllegalArgumentException(" arguments error, " + "come from @ModelAttribute: " + msg);
	}
}
