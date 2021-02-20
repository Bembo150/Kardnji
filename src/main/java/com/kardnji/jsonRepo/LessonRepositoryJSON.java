package com.kardnji.jsonRepo;

import com.kardnji.entity.Lesson;
import com.kardnji.util.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class LessonRepositoryJSON implements LessonRepository {
    
    String file;
    Map<String, Lesson> lessons;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public LessonRepositoryJSON(String path) {
        file = path;
        List<Lesson> rawLessons = gson.fromJson(Reader.fileReader(file),  new TypeToken<List<Lesson>>(){}.getType());
        lessons = rawLessons.stream().collect(Collectors.toMap(Lesson::getName, lesson -> lesson));
    }

    /**
     * Guarda los cambios a la base de datos JSON
     * @return false si falla la escritura, true si sale bien
     */
    public boolean commitChanges() {
        //TO-DO
        return true;
    }

	@Override
	public void save(Lesson e) {
		lessons.put(e.getName(), e);
	}

	@Override
	public void delete(Lesson e) {
		lessons.remove(e.getName());
	}

	@Override
	public void update(Lesson e) {
		lessons.put(e.getName(), e);
	}
	

	@Override
	public Lesson read(String name) {
		return lessons.get(name);
	}

}
