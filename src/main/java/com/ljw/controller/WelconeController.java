package com.ljw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelconeController {
	@RequestMapping(value="/welcome")
	public String myWindows() {
		
		
		return  "welcome";
		
	}
}
