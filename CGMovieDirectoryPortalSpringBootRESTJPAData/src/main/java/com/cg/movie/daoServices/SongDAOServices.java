package com.cg.movie.daoServices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.beans.Song;

public interface SongDAOServices extends JpaRepository<Song, Integer>{

}
