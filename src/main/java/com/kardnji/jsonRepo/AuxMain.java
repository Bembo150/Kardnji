package com.kardnji.jsonRepo;

import java.util.ArrayList;
import java.util.List;

import com.kardnji.entity.Kard;
import com.kardnji.enums.Lesson;

public class AuxMain {

	public static void main(String[] args) {
		List<Kard> kards = new ArrayList<Kard>();
		KardRepositoryImpl kr = new KardRepositoryImpl();
		kards = kr.read(Lesson.LESSON1);
		
		kards.forEach(l -> System.out.println(l.toString()));
		
		
		
	}

}
