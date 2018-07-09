package com.ljw.domain.movie;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="TABLE_MOVIE")
public class Movie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7940451902534786103L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="movieid")
	private Long movieId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="duration")
	private Long duration;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", duration=" + duration + "]";
	}
	

	
	


	
}
