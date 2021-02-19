package com.kardnji.jsonRepo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kardnji.constantes.JsonPathConstants;
import com.kardnji.entity.Kard;
import com.kardnji.util.FileReader;

public class KardRepositoryImpl implements KardRepository{
	
	List<Kard> kards = new ArrayList<Kard>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Override
	public void save(Kard e) {

		if(FileReader.fileReader(JsonPathConstants.kanjiFilePath).equals("")) {
			System.out.println("Vacio");
		}else {
			kards = gson.fromJson(Reader.fileReader(JsonPathConstants.kanjiFilePath), new TypeToken<List<Kard>>(){}.getType());
			kards.add((Kard) e);
		}
		
		escribirJSON();
		
	}

	@Override
	public Kard read(Integer sf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Kard e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Kard e) {
		// TODO Auto-generated method stub
		
	}
	
	private void escribirJSON() {
		try {
			FileWriter fw = new FileWriter(JsonPathConstants.kanjiFilePath, false);
			fw.write(gson.toJson(kards));
			fw.flush();
			fw.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		kards.removeAll(kards);
	}

}
