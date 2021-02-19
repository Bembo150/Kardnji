package com.kardnji.jsonRepo;

import com.kardnji.entity.Kanji;
import com.kardnji.entity.Kard;

public class AuxMain {

	public static void main(String[] args) {
		
		KardRepository kr = new KardRepositoryImpl();
		
		Kard k = new Kanji();
		k.setId(1);
		k.setImageUrl("src/main/resources/imgprueba2.png");
		k.setKeyWord("Sol");
		k.setShortStory("Parece un sol");
		
		kr.save(k);
	}

}
