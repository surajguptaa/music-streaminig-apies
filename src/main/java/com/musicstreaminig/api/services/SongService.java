package com.musicstreaminig.api.services;

import java.util.List;

import com.musicstreaminig.api.entities.Song;
import com.musicstreaminig.api.payloads.SongDto;

public interface SongService {
	
	//create
	
	SongDto createSong(SongDto songDto, Integer userId, Integer categoryId);
	
	//update
	Song updateSong(SongDto songDto, Integer songId);
	
	//delete
	Song deleteSong(Integer songId);
	
	
	//get all songs
	List<Song> getAllSong();
	
	//get song by id
	
	Song getSongById(Integer songId);
	
	//get song by category
	List<Song> getSongByCategory(Integer categoryId);
	
	//get song by user
	List<Song> getSongByUser(Integer userId);
	
	//search song
	List<Song> searchSongs(String keyword);
}
