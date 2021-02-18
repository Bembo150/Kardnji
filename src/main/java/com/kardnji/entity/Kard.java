package com.kardnji.entity;

public class Kard {

	private String kanjiImage;
	private int kanjiId;
	private String keyWord;
	private String shortStory;
	
	public Kard(String kanjiImage, int kanjiId, String keyWord, String shortStory) {
		super();
		this.kanjiImage = kanjiImage;
		this.kanjiId = kanjiId;
		this.keyWord = keyWord;
		this.shortStory = shortStory;
	}

	public String getKanjiImage() {
		return kanjiImage;
	}

	public void setKanjiImage(String kanjiImage) {
		this.kanjiImage = kanjiImage;
	}

	public int getKanjiId() {
		return kanjiId;
	}

	public void setKanjiId(int kanjiId) {
		this.kanjiId = kanjiId;
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
