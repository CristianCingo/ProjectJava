package it.univpm.Project.filter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Filtraggio di un generico tipo T
 * @param <T>
 */

public class Filter<T> {
	
	/**
	 * Viene restituito true se l'oggetto value è 'equals' all'oggetto th 
	 * Per oggetti numerici si controlla se l'operatore è "<","<=",">",">=","=="
	 * Per oggetti stringa si controlla se questi due sono uguali 
	 * @param value, oggetto da confrontare
	 * @param operator, operatore per il confronto
	 * @param th, oggetto con il quale si esegue il confronto
	 * @return
	 */
	
	public static boolean check(Object value, String operator, Object th){
		if (th instanceof Number && value instanceof Number) {	
			Double thC = ((Number)th).doubleValue();
			Double valuec = ((Number)value).doubleValue();
			
			
			if (operator.equals("=="))
				return value.equals(th);
			else if (operator.equals(">"))
				return valuec > thC;
			else if (operator.equals("<"))
				return valuec < thC;
			else if (operator.equals("<="))
				return valuec<=thC;
			else if (operator.equals(">="))
				return valuec>=thC;
				
		}else if(th instanceof String && value instanceof String)
			return value.equals(th);
		return false;		
	}
	
	/**
	 * Metodo ricorsivo che restituisce una collection di dati di tipo generico T filtrati. 
	 * Caso Base ricorsione:la lista logicalLinkOperator è nulla o vuota, viene eseguito un solo filtro
	 * Si richiama la ricorsione considerando per ciascun parametro la sottolista e come source dei dati
	 * Si considera la collection uscente dall'istanza ricorsiva chiamante nel caso AND, viene poi considerato il filtro successivo
	 * Si considera la collection sorgente dell'istanza ricorsiva chiamante nel caso OR.
	 * @param src, collection sorgente di dati di tipo generico T
	 * @param fieldName, lista di campi sul quale effettuare il filtro per ciascun oggetto nella collection src
	 * @param operator, lista degli operatori da utilizzare per effettuare ciascun filtro
	 * @param value, lista dei valori da compare per ogni filtro
	 * @param logicalLinkOperator, lista dei operatori logici (AND, OR )che collegano ciascun filtro 
	 * @return
	 */
	
public Collection<T> select(Collection<T> src, List<String> fieldName,List<String>  operator, List<Object> value,List<String> logicalLinkOperator){
		
		//Caso base
		Collection<T> out = new ArrayList<T>();		
		for(T item:src) {		//ogni elemento della source collection viene analizzato
			try {
				Method m = item.getClass().getMethod("get"+fieldName.get(0).substring(0, 1).toUpperCase()+fieldName.get(0).substring(1),null);	
				
				try {
					Object tmp = m.invoke(item);		//restituisce i valori di ogni campo
					if(Filter.check(tmp, operator.get(0), value.get(0)))	//verifica se rispetta il filtro, in caso affermativo viene inserito nella collection
						out.add(item);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}					
		}
		//Parte ricorsiva: viene lanciato qunado logicalLinkOperator non è nulla (uso di OR o AND)
				if (logicalLinkOperator!=null && logicalLinkOperator.size()>0)	/*Quando logicalLinkOperator è nulla viene lasciata la parte ricorsiva*/
				{
					List<String> subLogicalLinkOperator=null;
					if (logicalLinkOperator.size()>1)
						subLogicalLinkOperator=logicalLinkOperator.subList(1, logicalLinkOperator.size());
					
					if (logicalLinkOperator.get(0).equals("AND"))	/*Con AND la collection esterna diventa la src collection attuale della chiamata ricorsiva*/
																	
						return select(out,fieldName.subList(1, fieldName.size()),operator.subList(1, operator.size()),value.subList(1,value.size()),subLogicalLinkOperator);
					else
					{
						Collection<T> temp=select(src,fieldName.subList(1, fieldName.size()),operator.subList(1, operator.size()),value.subList(1,value.size()),subLogicalLinkOperator);
						out.addAll(temp);	
					}
				}
				return out;
			}

}
