package com.kardnji.entity;

import com.kardnji.enums.Lesson;

public class Kard {
	
	private int id;
	private String imageUrl;
	private String keyWord;
	private String shortStory;
	private String asComponent;
	private Lesson lesson;
	
	public Kard() {
	}
	
	public Kard(int id, String imageUrl, String keyWord, String shortStory, Lesson lesson, String asComponent) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.keyWord = keyWord;
		this.shortStory = shortStory;
		this.lesson = lesson;
		this.asComponent = asComponent;
	}

	public String getAsComponent() {
		return asComponent;
	}

	public void setAsComponent(String asComponent) {
		this.asComponent = asComponent;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getShortStory() {
		return shortStory;
	}

	public void setShortStory(String shortStory) {
		this.shortStory = shortStory;
	}
	
}
