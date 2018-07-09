package com.ljw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ljw.cache.CacheManager;
import com.ljw.domain.people.Student;

/**
 * 视图信息处理模式
 * @author PC
 *
 */

@Controller
public class JspController {
	private static Logger log = LoggerFactory.getLogger(JspController.class);

	
	@Value("${testController_path}")
	private String url;
	
	@RequestMapping("/testljw")
	public String test(){
		
		return url;
	}
	
	
	
	
	
	@Autowired
	private CacheManager testManager;
	
	@RequestMapping("/test1")
	public String testJsp(Map<String, Object> map) {

		Student student = new Student();
		student.setName("111");
		student.setAge(14L);
		student.setSex("man");
		
		Student student1 = new Student();
		student1.setName("333");
		student1.setAge(18L);
		student1.setSex("woman");
		
		Student student2 = new Student();
		student2.setName("444");
		student2.setAge(19L);
		student2.setSex("man");
		map.put("object", student);
		
		
		List<Student> slist =new ArrayList<Student>();
		slist.add(student);
		slist.add(student1);
		slist.add(student2);
		map.put("list", slist);
		
		
		String testmap = testManager.getTestmap(3L);
		map.put("result", testmap);
		
	
		log.info(map.toString());
		
		return "controllerTest";

	}
}
