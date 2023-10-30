package com.musicstreaminig.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicstreaminig.api.payloads.SongDto;
import com.musicstreaminig.api.services.SongService;

@RestController
@RequestMapping("/api/")
public class SongController {
	
	@Autowired
	private SongService songService;
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/songs")
	public ResponseEntity<SongDto>createSong(
			@RequestBody SongDto songDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId
			)
	{
	 SongDto createdSong =	this.songService.createSong(songDto, userId, categoryId);
	 return new ResponseEntity<SongDto>(createdSong, HttpStatus.CREATED);
	}
	
	
	

}
