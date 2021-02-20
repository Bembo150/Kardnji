package com.kardnji.entity;

import com.kardnji.enums.Lesson;

public class Kanji extends Kard{

	public Kanji() {}
	
	public Kanji(int id, String imageUrl, String keyWord, String shortStory, Lesson lesson, String asComponent) {
		super(id, imageUrl, keyWord, shortStory, lesson, asComponent);
	}
	
	
}
