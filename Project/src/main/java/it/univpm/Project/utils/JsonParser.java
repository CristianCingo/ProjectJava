package it.univpm.Project.utils;

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
	
	public JsonParser()
	{
	}
	
	/**
	 * Memorizza le informazioni del dataset in un Arraylist di oggetti 
	 */
	public void parse(ArrayList<Funding> af) throws FileNotFoundException, IOException, NullPointerException, NumberFormatException {
		String input;
		ArrayList<String> text = new ArrayList<String>();
		try {
		    BufferedReader reader = new BufferedReader(new FileReader("dataFile.json"));
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
