package com.ljw.repository.people;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ljw.domain.people.Student;

/**
 * studentJPA数据接口
 * 用于提供数据库查询的各种语句操作
 * @author PC
 *
 */
public interface StudentRepository extends JpaRepository<Student,Long> ,StudentExInterface{

	
	/**
	 * 通过名字找人
	 * @param name
	 * @return
	 */
	public List<Student> findByName(@Param("name") String name);
	
	
}
