package it.univpm.Project.utils;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.List;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.StandardCopyOption;

import java.security.KeyException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import java.util.ArrayList;
import java.util.Map;

/**
 * Classe contenente le funzioni di download dei dati json in un dataset json tramite URL
 * @author Cristian Cingolani e Christian Ascani
 *
 */
public class ParseJSON {
	private String str, line;  //Stringa su cui viene memorizzato il contenuto
	private URL link;
	private BufferedReader input;
	/**
	 * Costruttore che copia il contenuto dell'URL e lo memorizza in una variabile di tipo String
	 * dalla quale poi si effettua il download
	 * @param url L'indirizzo web nel quale è contenuto il link al dataset
	 */
	public ParseJSON(String url) throws MalformedURLException, IOException
	{
		this.str = "";
		this.line = "";
		this.link = new URL(url);
	    this.input = new BufferedReader(new InputStreamReader(link.openStream()));
	    
	    while ((line = input.readLine()) != null)
	    {
	    	str += line;
	    }
	    input.close();
	}
	
	/**
	 * Converte la stringa precedentemente salvata in un oggetto di tipo JSON
	 * per poi andare a localizzare la posizione dell'URL del dataset desiderata.
	 * Dopodiché legge il contenuto dell'URL e ne effettua una copia salvata su un file in locale.
	 * Nel caso in cui il programma ha scaricato in passato il json dei dati viene eseguita
	 * un FileAlreadyExistException: il metodo controlla se il timeStamp del json che sta per
	 * scaricare è antecedente alla data dell'ultima modifica del file scaricato.
	 */
	public boolean readFile() {
	DateFormat dateFormat = new SimpleDateFormat("E d MMMM yyyy", Locale.ITALIAN);	//get the date format
	Date date=null;
	String format = "", urlData = "";

	try {
		
		URLConnection openConnection = new URL(str).openConnection();		//Opening the connection
		openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		InputStream input = openConnection.getInputStream();
		
		 String data = "";
		 String line = "";
		 
		 System.out.println("Reading data from the URL...");
		 
		 try {			
		   InputStreamReader inStRead = new InputStreamReader( input );
		   BufferedReader bRead = new BufferedReader( inStRead );
		  
		   while ( ( line = bRead.readLine() ) != null ) {		//Reading data from the url
			   data+= line;
		   }
		 } finally {
		   input.close();		                                //After the connection is closed
		 }
		 
		 System.out.println("Data read correctly!");
		 System.out.println("Parsing the json...");
		 
		JSONObject mainObj = (JSONObject) JSONValue.parseWithException(data);  //Parsing all the data read from string to JSON, which is used in
																			   //order to create the main JSONObject where everything is stored
		JSONObject resultObj = (JSONObject) (mainObj.get("result")); 	       //Identifying the "result" object into the main JSONObject
		JSONArray resourcesObj = (JSONArray) (resultObj.get("resources"));	   //Identifying the "resources" array into the "result" JSONObject
		System.out.println("JSON parsed!");
		
		System.out.println("Starting download file JSON...");
		for(Object x: resourcesObj){	            //for each element of resourcesObj
		    if ( x instanceof JSONObject ) {
		        JSONObject jOb = (JSONObject)x;     //each element into the array is converted into a JSONObject
		        format = (String)jOb.get("format"); //get the format of the file identified by this resource object
		        date = dateFormat.parse((String)jOb.get("revision_timestamp"));	 //Convert the String date identified by the "revision_timestamp"
  																		         //into a Date type object, using the dateFormat defined
		        urlData = (String)jOb.get("url");		//get the url of the resource
		        System.out.println(format + " | " + date + " | " + urlData);
		        if(format.equals("json")) {		    //data is downloaded only if the format is json
		        	downloadJSON(urlData, "dataFile.json");
		        	return true;
		        }
		    }
		}
	}catch (FileAlreadyExistsException e) 	         //this exception is thrown when the file already exists
	{
		
		File dataFile = new File("dataFile.json");
		String fileDataString =	dateFormat.format(dataFile.lastModified());		//get the data of the last edit of the file
		Date fileData = null;
		try {
			fileData = dateFormat.parse(fileDataString);                        //convert the data of the file into date type
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		if(fileData.compareTo(date)>0)	                  //.compareTo method returns int>0 if fileData>date whilst it returns int <0 if date>fileData
			System.out.println("The data file already exists | Last edit: " + fileDataString);
		else
		{
			
			if (dataFile.delete())		//the old data file is deleted and then the new data is downloaded
				{try {
					downloadJSON(urlData, 
							"dataFile.json");
					return true;
				} catch (Exception e1) {
					e1.printStackTrace();
					return false;
				}
				
				}else
				{
					System.out.println("Unable to delete the older dataFile.json");
					return false;
				}
		}
		
		
	} catch (IOException e) {			
		e.printStackTrace();
		return false;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
	return true;
}
	/**
	 * Metodo statico che scarica in un file i dati JSON contenuti in un URL.
	 * @param url, link downloader del file json
	 * @param fileName, file nel quale saranno memorizzati i dati
	 * @throws Exception
	 */
	
	public static void downloadJSON(String url, String fileName) throws Exception {		//its function is to copy the json from the url into 
																						//a file named by the value of the variable "fileName"
	    try (InputStream input = URI.create(url).toURL().openStream()) {
	        Files.copy(input, Paths.get(fileName));
	    }
	    System.out.println("Data download completed from " + url);
	}
}