package com.paul.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@Autowired
	DemoService demoService;

	@RequestMapping("hellooo")
	@ResponseBody
	public String hello(HttpServletRequest resquest, HttpServletResponse response) {
		return "URL " + resquest.getRequestURL() + ", :welcome to test message!";
	}

	@RequestMapping("/normal")
	public String testPage(Model model) {
		model.addAttribute("msg", demoService.saySomething());
		return "page";
	}

	@RequestMapping(value = "/testRest", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String testRest() {
		return demoService.saySomething();
	}

}