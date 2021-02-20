package com.kardnji.entity;

import com.kardnji.enums.Lesson;

public class Kard {
	
	private int id;
	private String imageUrl;
	private String keyWord;
	private String shortStory;
	private Lesson lesson;
	private String asComponent;
	
	public Kard(int id, String imageUrl, String keyWord, String shortStory, Lesson lesson, String asComponent) {
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

	public Lesson getLesson() {
		return lesson;
	}

	public int getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public String getShortStory() {
		return shortStory;
	}

	@Override
	public String toString() {
		return "Kard [id=" + id + ", imageUrl=" + imageUrl + ", keyWord=" + keyWord + ", shortStory=" + shortStory
				+ "]";
	}
}
