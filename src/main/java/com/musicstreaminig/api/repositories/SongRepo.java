package com.musicstreaminig.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicstreaminig.api.entities.Category;
import com.musicstreaminig.api.entities.Song;
import com.musicstreaminig.api.entities.User;

public interface SongRepo extends JpaRepository<Song, Integer>{
	
	List<Song> findByUser(User user);
	
	List<Category> findByCategory(Category category);
	
	

}
