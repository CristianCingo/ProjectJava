package it.univpm.Project.statistics;

import java.lang.reflect.Method;
import java.util.ArrayList;

import it.univpm.Project.dataset.Funding;

/**
 * Superclasse utile per il calcolo delle statistiche
 * @author Cingolani Cristian & Ascani Christian
 */

public class StatBasic {
	protected ArrayList<Funding> af;
	protected Method m;
	
	/**
	 * Costruttore della superclasse
	 * @param param
	 * @param af
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public StatBasic(String param, ArrayList<Funding> af) throws NoSuchMethodException, SecurityException
	{
		this.af = af;
		m = af.get(0).getClass().getMethod("get"+param.substring(0, 1).toUpperCase()+param.substring(1));
	}
}
