package it.univpm.Project.filter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;

import it.univpm.Project.dataset.Funding;
import it.univpm.Project.filter.RepInterface;


public class RepFunding<ArrayFunding> implements RepInterface<Funding>{
	
	private static final String filename ="C:\\\\fileName.json";  
	private static List<Funding> FundingList=new ArrayList<Funding>();
	private static Filter<Funding> filterService=new Filter<Funding>(); 
	
	
	
	/**
	 * Il costruttore effettua un parsing dei dati all'interno del json in data object
	 * mediante l'utilizzo della libreria univocity-parser json: viene popolata la collection hotelList.
	 * @throws IOException 
	 * @throws JsonIOException 
	 */
	public RepFunding()
	{
		try {
		Gson gson = new Gson();

		// 1. Java object to JSON file
		gson.toJson(FundingList, new FileWriter(filename));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	//region method not used
	
	@Override
	public void add(Funding item) {
		
	}

	@Override
	public void update(Funding item) {		
	}

	@Override
	public void remove(Funding item) {
		
	}

	@Override
	public List<Funding> query(String filter) {
		return null;
	}
	
	//endregion

	/**
	 * Restituisce l'intera collection contenente i dati.
	 */
	@Override
	public List<Funding> getAll() {
		
		return FundingList;
	}
	
	/**
	 * Restituisce la lista degli hotel filtrata utilizzando il metodo select dell'oggetto filterService.
	 * @param fieldName, lista dei campi sul quale effettuare il filtraggio
	 * @param operator, lista degli operatori da utilizzare per ogni filtro
	 * @param value, lista dei valori da compare per ogni filtro
	 * @param logicalLinkOperator, lista dei operatori logici (AND, OR )che collegano ciascun filtro 
	 * (in caso in cui la variabile filter contenesse più filtri).
	 * @return
	 */
	
	public List<Funding> filterField(List<String> fieldName, List<String> operator, List<Object> value,List<String> logicalLinkOperator) {
		return (List<Funding>) filterService.select(FundingList, fieldName, operator, value,logicalLinkOperator);
	}
}
	
	
