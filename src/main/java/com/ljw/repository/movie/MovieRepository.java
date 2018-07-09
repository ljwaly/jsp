package com.ljw.repository.movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ljw.domain.movie.Movie;

/**
 * movieJPA数据接口
 * 用于提供数据库查询的各种语句操作
 * @author PC
 *
 */
public interface MovieRepository extends JpaRepository<Movie,Long> {

	
	/**
	 * 通过名字找人
	 * @param name
	 * @return
	 */
	public List<Movie> findByName(@Param("name") String name);
	
	
}
