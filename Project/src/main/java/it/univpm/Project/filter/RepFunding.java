package it.univpm.Project.filter;

import java.util.ArrayList;
import java.util.List;

import it.univpm.Project.dataset.Funding;
import it.univpm.Project.utils.JsonParser;

/**
 * Repository che contiene i dati degi funding, prelevandoli dal file dataFile.json. Implementa
 * l'interfaccia RepInterface<Funding>.
 * @author Cristian Cingolani & Christian Ascani
 */

public class RepFunding implements RepInterface<Funding>{
	
	private static final String filename = "dataFile.json";  
	private static List<Funding> FundingList = new ArrayList<Funding>();
	private static Filter<Funding> filterService = new Filter<Funding>(); 
	
	/**
	 * Il costruttore effettua un parsing dei dati all'interno del json in data object
	 * mediante l'utilizzo di JsonParser: viene popolata la collection FundingList.
	 */
	public RepFunding() 
	{
		try {
			JsonParser parser = new JsonParser(filename);
			parser.parse();
			
		} catch (Exception e) {
			e.printStackTrace();
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
	 * Restituisce la lista di Funding filtrata utilizzando il metodo select dell'oggetto filterService.
	 * @param fieldName, lista dei campi sul quale effettuare il filtraggio
	 * @param operator, lista degli operatori da utilizzare per ogni filtro
	 * @param value, lista dei valori da comparare per ogni filtro
	 * @param logicalLinkOperator, lista dei operatori logici (AND, OR)che collegano ciascun filtro 
	 * (in caso in cui la variabile filter contenesse più filtri).
	 * @return
	 */
	
	public List<Funding> filterField(List<String> fieldName, List<String> operator, List<Object> value,List<String> logicalLinkOperator) {
		return (List<Funding>) filterService.select(FundingList, fieldName, operator, value,logicalLinkOperator);
	}
}