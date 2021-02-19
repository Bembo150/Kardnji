package com.kardnji.entity;

public class Kard {
	
	private int id;
	private String imageUrl;
	private String keyWord;
	private String shortStory;
	
	public Kard() {
	}
	
	public Kard(int id, String imageUrl, String keyWord, String shortStory) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.keyWord = keyWord;
		this.shortStory = shortStory;
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
