package com.musicstreaminig.api.entities;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="song")
@Getter
@Setter
@NoArgsConstructor
public class Song {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer songId;
	
	@Column(name="songName")
	private String songName;
	
	
	@ManyToAny
	private Category category;
	
	@ManyToAny
	private User user;
	
	

}
