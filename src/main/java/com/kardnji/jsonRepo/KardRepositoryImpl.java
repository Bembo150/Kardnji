package com.kardnji.jsonRepo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kardnji.constantes.JsonPathConstants;
import com.kardnji.entity.Kard;
import com.kardnji.enums.Lesson;
import com.kardnji.util.Reader;

public class KardRepositoryImpl implements KardRepository{
	
	List<Kard> kards = new ArrayList<Kard>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Override
	public void save(List<Kard> e) {
		
	}

	@Override
	public void delete(List<Kard> e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(List<Kard> e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public List<Kard> read(Lesson lesson) {
	
		String lessonPath = JsonPathConstants.lessonPath.concat(lesson.toString().toLowerCase()).concat(".txt");
		kards = gson.fromJson(Reader.fileReader(lessonPath),  new TypeToken<List<Kard>>(){}.getType());
		return kards;
	}


}
