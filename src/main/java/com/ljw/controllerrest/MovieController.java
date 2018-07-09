package com.ljw.controllerrest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljw.domain.movie.Movie;
import com.ljw.domain.people.Student;
import com.ljw.repository.movie.MovieRepository;

@RestController
@RequestMapping("/movie")
public class MovieController extends BaseController {

	@Autowired
	private MovieRepository movieRepository;
	
	@RequestMapping("/test")
	public Map<String, Object> test(){
		
		
		
		
		Map<String, Object>  map = new HashMap<String, Object>();
		
		try {
			Thread.sleep(300000L);
			map.put("result", "success");
			return map;
		} catch (Exception e) {
			map.put("result", "fail");
		}
		
		Movie m = new Movie();
//		m.setMovieId("1");
		m.setDuration(180L);
		m.setName("zhanlang");
		Movie save = movieRepository.save(m);
		map.put("result", save);
		
		return map;
	}
	
	//http://localhost:8085/movie/save?name=xiaoxiao&duration=180
	@RequestMapping("/save")
	public Map<String, Object> saveStu(Movie movie){
		Map<String, Object>  map = new HashMap<String, Object>();
		
		
		Movie save = movieRepository.save(movie);
		map.put("result", save);
		
		return map;
	}
	
	@RequestMapping("/getAll")
	public Map<String, Object> getAllMovie(){
		Map<String, Object>  map = new HashMap<String, Object>();
		
	
		List<Movie> findAll = movieRepository.findAll();
		map.put("result", findAll);
		
		return map;
	}
	
	
	
}
