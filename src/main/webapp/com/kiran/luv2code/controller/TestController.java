package main.webapp.com.kiran.luv2code.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/test/hello")
	public String helloWorld() {
		return "hello"; //-> /WEB-INF/jsp/hello.jsp
	}
	
	@RequestMapping("/test/ajax_test")
	public String testPage() {
		return "test"; //-> /WEB-INF/jsp/hello.jsp
	}
	
	@RequestMapping("/test/get_time")
	@ResponseBody
	public String getServerTime() {
		System.out.println("GetServer time");
		Date d = new Date();
		return d.toString(); //If we use @ResponseBody, Instead of returning a page, it returns response
	}
}
