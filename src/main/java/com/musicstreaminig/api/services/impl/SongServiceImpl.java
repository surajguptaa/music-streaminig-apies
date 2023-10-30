package com.musicstreaminig.api.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstreaminig.api.entities.Category;
import com.musicstreaminig.api.entities.Song;
import com.musicstreaminig.api.entities.User;
import com.musicstreaminig.api.exceptions.ResourceNotFoundException;
import com.musicstreaminig.api.payloads.SongDto;
import com.musicstreaminig.api.repositories.CategoryRepo;
import com.musicstreaminig.api.repositories.SongRepo;
import com.musicstreaminig.api.repositories.UserRepo;
import com.musicstreaminig.api.services.SongService;


@Service
public class SongServiceImpl implements SongService {
	
	@Autowired
	private SongRepo songRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	

	@Override
	public Song createSong(SongDto songDto, Integer userId, Integer categoryId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
		Category category =  this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));

	Song song = this.modelMapper.map(songDto, Song.class);
	song.setSongName("default.mp3");	
	song.setUser(user);
	song.setCategory(category);
	
	Song newSong =  this.songRepo.save(song);
	
		return this.modelMapper.map(newSong, Song.class);
	}

	@Override
	public Song updateSong(SongDto songDto, Integer songId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song deleteSong(Integer songId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> getAllSong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song getSongById(Integer songId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> getSongByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> getSongByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> searchSongs(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
