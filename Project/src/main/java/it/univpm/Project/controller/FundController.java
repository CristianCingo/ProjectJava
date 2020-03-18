package it.univpm.Project.controller;

import it.univpm.Project.dataset.Data;
import it.univpm.Project.dataset.Funding;
import it.univpm.Project.dataset.Metadati;
import it.univpm.Project.filter.RepFunding;
import it.univpm.Project.statistics.StatNum;
import it.univpm.Project.statistics.StatStr;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controller relativo ai dati di ciascun Funding, fa riferimento ad una RepFunding:
 * questa è una variabile statica in quanto la struttura dati sul quale si fa riferimento (contenuta all'interno della suddetta
 * repository) deve essere univoca per ogni chiamata API effettuata al controller.
 * @author Cristian Cingolani & Christian Ascani
 */

@RestController
public class FundController {
	
	private static RepFunding repo = new RepFunding(); 
	
	/**
	 * Restituisce la lista dei dati
	 */
	@GetMapping("/data")
	public ArrayList<Funding> stampaDati()
	{
		return Data.getArrFunding();
	}
	
	/**
	 * Restituisce la lista dei metadati
	 */
	@GetMapping("/metadata")
	public ArrayList<Metadati> stampaMeta()
	{
		return Data.getArrMeta();
	}
	
	/**
	 * Restituisce le statistiche per i dati numerici
	 */
	@GetMapping("/stat/num")
	public double[] stampaStatNum(@RequestParam(name="param", defaultValue="") String param) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		StatNum ns = new StatNum(param, Data.getArrFunding());
		return ns.getStat();
	}
	
	/**
	 * Restituisce le statistiche per i dati "String"
	 */
	@GetMapping("/stat/str")
	public Map<String, Integer> stampaStatStr(@RequestParam(name="param", defaultValue="") String param) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		StatStr strs = new StatStr(param, Data.getArrFunding());
		return strs.getOccorrenze();
	}
	
	/**
	 * Filtri
	 * restituisce i dati relativi a tutti i funding se il filtro impostato è null, 
	 * restituisce i dati filtrati se è applicato un filtro
	 * Struttura filtro
	 *?filter=PrimoCampo:operatore(<,>,<=,>=,==):PrimoValore:operatoreLogico(AND,OR):SecondoCampo:operatore:SecondoValore....
	 * I filtri non possono essere impostati su tutti i campi
	 * 
	 * @param filter
	 * @return
	 */

	@GetMapping("/funding/get") 
	public List<Funding> getFiltered(@RequestParam(value="filter",defaultValue="",required=false) String filter)
	{
		if (filter.equals(""))		
			return stampaDati();		
		else
		{
			List<String> fieldNameList=new ArrayList<String>(); 
			List<String> operatorList=new ArrayList<String>();
			List<Object> valueList=new ArrayList<Object>();
			List<String> logicalLinkOperator=new ArrayList<String>();
			String[] filtering=filter.split(":");
			
			int maxIndex=(filtering.length/4 );	
			if (filtering.length%4>0)
				maxIndex++;
			for (int i=0;i<maxIndex;i++)
			{
				String field=filtering[0+(4*i)];
				String operator=filtering[1+(4*i)];
				String value=filtering[2+(4*i)];
			
				fieldNameList.add(field); 
				operatorList.add(operator);
				
			
				double a;
				a=Double.parseDouble(field);	
				
				valueList.add(a);

				if (filtering.length>(3+(4*i)))		
					logicalLinkOperator.add(filtering[3+(4*i)]);
				
			}
			return repo.filterField(fieldNameList, operatorList, valueList,logicalLinkOperator);	
		}
	}
	

}
