package it.univpm.Project.utils;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.List;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.KeyException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Classe contenente le funzioni di utilizzo generico
 * @author Cristian Cingolani e Christian Ascani
 *
 */
public class ParseJSON {
	public static URLConnection openConnection;
	public static InputStream input;
	
	/**
	 * Metodo che apre la connessione per il download del file JSON
	 * @throws IOException
	 */
    public static void openConnection() throws IOException
    {
		openConnection = new URL("https://www.dati.gov.it/api/3/action/package_show?id=bb6a09a7-af75-4fa5-805f-ed38eda6e883").openConnection();
		input = openConnection.getInputStream();
    }
 
    /**
     * Metodo che chiude la connessione
     * @throws IOException
     */
    
	public static void closeConnection() throws IOException
	{
		input.close();
	}
	
	/**
	 * Metodo che si riferisce al file JSON  dell' url
	 * passatogli come argomento e genera il JSON Object
	 * @param url link da scaricare in formato string
	 * @return json Oggetto JSON risultante dal download
	 * @throws IOException Eccezioni
	 * @throws ParseException Errori nel Parsing
	 */
    public static JSONObject getJSONFromURL(String url) throws IOException, ParseException {
        StringBuilder sb = new StringBuilder();
        int currentChar;
        
        // URL
        URL urlObj = new URL(url);
        URLConnection connection = (HttpURLConnection)urlObj.openConnection();
    	// Se è presente l'header "Location", segue automaticamente il redirect.
        if( connection.getHeaderField("Location") != null )
    	{
    		urlObj = new URL( connection.getHeaderField("Location") );
    		connection = (HttpURLConnection)urlObj.openConnection();
    	}
        
    	
        try(InputStream is = connection.getInputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //ReadLine
            while ((currentChar = br.read()) != -1){
                sb.append((char) currentChar);
            }
            
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(sb.toString());

            
            return json;
        }
    }

   
	
}