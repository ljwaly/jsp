package com.ljw.controllerrest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ljw.domain.people.Student;
import com.ljw.repository.people.StudentRepository;
import com.ljw.vo.response.ResultResponse;

@RestController
public class TransactionController extends BaseController{
	
	
	private Logger logger= LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@RequestMapping("/show")
	public ResultResponse<Student> newTes1t() throws Exception{
		
		ResultResponse<Student>  stuR =  new ResultResponse<Student>();
		List<Student> findAll = studentRepository.findAll();
		stuR.setResultList(findAll);
		
//		for (Student student : findAll) {
//			System.out.println(student);
//		}
		return stuR;
		
	}
	
	
	
	@Transactional(rollbackFor = {Exception.class})
	@RequestMapping("/trans")
	public Student newTest(@RequestParam String name, @RequestParam Long age, @RequestParam(required = false) String sex) throws Exception{
		
		Student student = new Student();
		student.setAge(age);
		student.setName(name);
		student.setSex(sex);
		
		System.out.println(student);
		Student save = studentRepository.save(student);
		System.out.println(save);
		
		if (save != null) {
			throw new IllegalArgumentException("回滚测试");
		}
		
		return save;
		
	}
	
	
}
