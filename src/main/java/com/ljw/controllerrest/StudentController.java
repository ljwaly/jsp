package com.ljw.controllerrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljw.domain.people.Student;
import com.ljw.repository.people.StudentRepository;
import com.ljw.vo.response.DefaultCode;
import com.ljw.vo.response.StudentResponse;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController{

	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("/getAll")
	public StudentResponse getStudentListByDataSQL(){
		List<Student> findAll = studentRepository.findAll();
		
		StudentResponse response = new StudentResponse();
		response.setResultCode(DefaultCode.SUCCESS);
		response.setResultDesc("get students success");
		response.setStudentList(findAll);
		
	
		
		return response;
		
	}
	
	
}
