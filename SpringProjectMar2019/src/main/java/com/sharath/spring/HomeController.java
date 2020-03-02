package com.sharath.spring;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;;

@Controller
public class HomeController {

	@RequestMapping("home1")	
	public String home() {
		
		
		return "webTestYsb.html";
	}
}
