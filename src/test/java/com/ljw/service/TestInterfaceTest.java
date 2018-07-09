package com.ljw.service;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestInterface.class})
@TestPropertySource(locations = { "classpath:application-dev.properties" })
public class TestInterfaceTest {

	
	@Autowired
	private TestInterface testInterface;
	
	@Test
	public void haveATest(){
		
		
		Map<String, Object> resultMap = testInterface.getResultMap();
		System.out.println("resultMap:"+resultMap);
		
		
		
	}
}
