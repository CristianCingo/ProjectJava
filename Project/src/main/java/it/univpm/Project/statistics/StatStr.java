package it.univpm.Project.statistics;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.univpm.Project.dataset.Funding;

public class StatStr extends StatBasic{
	
private Map<String, Integer> occorrenze;
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

public Map<String, Integer> getOccorrenze() {
	return occorrenze;
}

public void setOccorrenze(Map<String, Integer> occorrenze) {
	this.occorrenze = occorrenze;
}


}