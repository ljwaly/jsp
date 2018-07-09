package com.ljw.controllerrest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljw.service.TestInterface;

@RestController
public class SleepTestController {

	@Autowired
	private TestInterface testInterfacet;
	
	@RequestMapping("/sleep")
	public Map<String, Object> getSleep(){
		
		Map<String, Object> resultMap = testInterfacet.getResultMap();
		
		return resultMap;
	}
}
