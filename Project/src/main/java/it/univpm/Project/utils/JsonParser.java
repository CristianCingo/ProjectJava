package it.univpm.Project.utils;

import it.univpm.Project.dataset.Data;
import it.univpm.Project.dataset.Funding;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
	
	ObjectMapper mapper = new ObjectMapper();
	private String dataset;
	public ArrayList<Funding> af;

	public JsonParser(String dataset)
	{
		this.af=Data.getArrFunding();
		this.dataset=dataset;
	}
	
	public void parse() throws FileNotFoundException, IOException, NullPointerException, NumberFormatException {
		String input;
		ArrayList<String> text = new ArrayList<String>();
		try {
		    BufferedReader reader = new BufferedReader(new FileReader(dataset));
		    for (input = reader.readLine(); input != null; input = reader.readLine()) {
		         text.add(input);
		    }
		    af = (ArrayList<Funding>) Arrays.asList(mapper.readValue(input, Funding[].class));
		    reader.close();
		    
		} catch (FileNotFoundException fnfe) {
		    fnfe.printStackTrace();
		} catch(IOException ioe){
		    ioe.printStackTrace();
		}
		
    	}
}
