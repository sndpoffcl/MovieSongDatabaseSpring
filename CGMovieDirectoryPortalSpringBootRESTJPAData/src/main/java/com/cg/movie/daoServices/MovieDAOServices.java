package com.cg.movie.daoServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.cg.movie.beans.Movie;

public interface MovieDAOServices extends JpaRepository<Movie, Integer>{
	

}
