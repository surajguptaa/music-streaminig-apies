package com.musicstreaminig.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MusicStreaminigApiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicStreaminigApiesApplication.class, args);
	}
	
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
