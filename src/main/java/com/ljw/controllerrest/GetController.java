package com.ljw.controllerrest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ljw.cache.CacheManager;
import com.ljw.domain.people.Student;
import com.ljw.exception.sonexception.WrongParamException;
import com.ljw.repository.people.StudentRepository;
import com.ljw.service.TestInterface;
import com.ljw.service.TestInterface2;
import com.ljw.vo.response.DefaultCode;
import com.ljw.vo.response.ResultResponse;
import com.ljw.vo.response.StudentResponse;



/**
 * RestController简单控制器//这就是传说中的restful模式
 * @author PC
 *
 */
@RestController
@RequestMapping("/private/rest/getController")
public class GetController extends BaseController{
	
	private Logger logger= LoggerFactory.getLogger(GetController.class);
	
	
	@Autowired
	private TestInterface testInterface; 
	
	@Autowired
	private TestInterface2 testInterface2; 
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CacheManager cacheManager;
	
	
	@RequestMapping("/testDeal")
	public StudentResponse deal(){
		
		
		Student student = new Student();
		student.setName("zhang");
		student.setAge(20L);
		student.setSex("man");
		
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student);
		
		StudentResponse response =new StudentResponse();
		response.setResultCode(DefaultCode.SUCCESS);
		response.setResultDesc("get students success");
		response.setStudentList(studentList);
		
		logger.info(response.toString());
		
		return response;
		
	}
	
	@RequestMapping("/qryAll")
	public StudentResponse getStudentListByDataSQL(){
		List<Student> findAll = studentRepository.findAll();
		
		StudentResponse response = new StudentResponse();
		response.setResultCode(DefaultCode.SUCCESS);
		response.setResultDesc("get students success");
		response.setStudentList(findAll);
		
		logger.info(response.toString());
		
		return response;
		
	}
	
	@RequestMapping("/qryByName")
	public ResultResponse<Student> getStudentByName(@RequestParam String name) throws Exception{
		if(name==null||"".equals(name)){
			throw new WrongParamException("param of name is null,name required");
		}
		List<Student> findByName = studentRepository.findByName(name);
		
		
		
		try {
			//Map<String, Object> resultMap = testInterface.getResultMap();
			//System.out.println(resultMap);
			int creatMyMethod = studentRepository.creatMyMethod();
			System.out.println(creatMyMethod);
			
			
			for (Student student : studentRepository.findAll()) {
				System.out.println(student);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		ResultResponse<Student> response =new ResultResponse<Student>();
		String testmap = cacheManager.getTestmap(0L);
		response.setResultCode(DefaultCode.SUCCESS);
		response.setResultDesc("get students success");
		response.setResultList(findByName);
		
		logger.info(response.toString());
		
		return response;
		
	}
	
	
	//@RequestMapping("/test")
	public Map<String, Object> testInterface() throws Exception{
		
		
		System.out.println("\n\n请求拦截器头\n\n");
		
		Map<String, Object> resultMap =null;
		try {
			resultMap = testInterface.getResultMap();
		} catch (Exception e) {
			resultMap = new HashMap<String, Object>();
			resultMap.put("Exception:", e);
		}
		logger.info("resultMap="+resultMap);
		
		return resultMap;
		
	}
	
	
	@RequestMapping("/test")
	public Map<String, Object> testInterface2() throws Exception{
		
		
		System.out.println("\n\n请求拦截器头\n\n");
		
		Map<String, Object> resultMap =null;
		try {
			resultMap = testInterface2.getResultMap();
		} catch (Exception e) {
			resultMap = new HashMap<String, Object>();
			resultMap.put("Exception:", e);
			e.printStackTrace();
		}
		
		return resultMap;
		
	}
	
	
	
}
