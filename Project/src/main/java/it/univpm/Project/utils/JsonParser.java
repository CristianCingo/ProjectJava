package it.univpm.Project.utils;

import it.univpm.Project.dataset.Data;
import it.univpm.Project.dataset.Funding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class JsonParser {
	
	private FileReader reader;
	private String data;
	private String[] line;
	private ArrayList<Funding> af;
	
	public JsonParser(String data)
	{
		this.data = data;
		this.af = Data.getArrFunding();
	}
	
	public void parse() throws FileNotFoundException, IOException, NullPointerException, NumberFormatException {
		File jsonInputFile = new File("dataFile.json");
        InputStream is;
        is = new FileInputStream(jsonInputFile);
        
        // Create JsonReader from Json.
        JsonReader reader = Json.createReader(is);
        
        // Get the JsonObject structure from JsonReader.
        JsonObject empObj = reader.readObject();
        
        while ((line = reader.read()) != null)
        {
        	af.add(new Funding(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], data, data, data, data, data, data, Float.parseFloat(line[8]), 0, 0, 0, 0, 0));
        }
        reader.close();
	}
}
