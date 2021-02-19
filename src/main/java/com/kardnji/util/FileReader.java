package com.kardnji.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReader {
	
	public static String fileReader(String nombreFichero) {
		String json = "";
		String line = null;
		
		try {
			FileReader fr = new FileReader(nombreFichero);
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if(line != null) {
					json = json + line + "\n";
				}
			}while(line != null);
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return json;
		
	}

}