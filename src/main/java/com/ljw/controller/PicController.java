package com.ljw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 直接302重定向
 * @author ljw
 *
 */

@Controller
public class PicController {

	
	@RequestMapping("/pic")
	public String goToIndexPoi(){
		
		return "forward:/100.jpg";//直接映射jsp页面，不进行前后缀适配
	}
}
