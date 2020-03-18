package it.univpm.Project.statistics;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.univpm.Project.dataset.Funding;

/**
 * Calcolo statistiche di tipo Stringa (occorrenze)
 * @author Cingolani Cristian & Ascani Christian
 */

public class StatStr extends StatBasic{
	
private Map<String, Integer> occorrenze;

/**
 * Costruttore della classe StatStr
 * @param param
 * @param af
 * @throws NoSuchMethodException
 * @throws SecurityException
 */

public StatStr (String param, ArrayList<Funding> af) throws NoSuchMethodException, SecurityException
{
	super(param, af);
	this.occorrenze = new HashMap<>();
}


public void numeroOccorrenze() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
{
int cont = 0;
occorrenze = new HashMap<>();
for(int i=0; i<af.size(); i++)
{
if(occorrenze.containsKey((String)m.invoke(af.get(i))))
{
	cont = occorrenze.get((String)m.invoke(af.get(i)));
	occorrenze.put((String)m.invoke(af.get(i)),(cont+1));
}
else {
	occorrenze.put((String)m.invoke(af.get(i)),1);
}
}
}

public Map<String, Integer> getOccorrenze() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	numeroOccorrenze();
	return occorrenze;
}

public void setOccorrenze(Map<String, Integer> occorrenze) {
	this.occorrenze = occorrenze;
}


}
