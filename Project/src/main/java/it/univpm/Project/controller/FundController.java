package it.univpm.Project.controller;

import it.univpm.Project.dataset.Data;
import it.univpm.Project.dataset.Funding;
import it.univpm.Project.dataset.Metadati;
import it.univpm.Project.statistics.StatNum;
import it.univpm.Project.statistics.StatStr;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Controller dell'applicazione che gestisce tutte le rotte della rest API
 * @author Cristian Cingolani & Christian Ascani
 */
@RestController
public class FundController {
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
	 * Restituisce le statistiche per i dati di tipo numerico
	 */
	@GetMapping("/stat/num")
	public double[] stampaStatNum(@RequestParam(name="param", defaultValue="") String param) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		StatNum ns = new StatNum(param, Data.getArrFunding());
		return ns.getStat();
	}
	/**
	 * Restituisce le statistiche per i dati di tipo "String"
	 */
	@GetMapping("/stat/str")
	public Map<String, Integer> stampaStatStr(@RequestParam(name="param", defaultValue="") String param) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		StatStr strs = new StatStr(param, Data.getArrFunding());
		return strs.getOccorrenze();
	}
	
}
