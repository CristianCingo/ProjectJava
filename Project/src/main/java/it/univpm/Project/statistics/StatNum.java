package it.univpm.Project.statistics;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import it.univpm.Project.dataset.Funding;

/**
 * Calcolo statistiche di tipo numerico
 * @author Cingolani Cristian & Ascani Christian
 */

public class StatNum extends StatBasic{

	private double arrStat[] = new double[6];
	public StatNum(String param, ArrayList<Funding> af) throws NoSuchMethodException, SecurityException
	{
		super(param, af);
	}
	
	/**
	 * Calcolo somma
	 */
	private double sum () throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		double sum=0;
		for (int i=0; i<af.size(); i++)
		{
			sum += (double)m.invoke(af.get(i));
		}
				
			return (sum);
		}
	
	/**
	 * Calcolo media
	 */
	private double avg () throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
	      double x=sum();
	 try {
	      return (x/af.size());
	     } catch(ArithmeticException e)
	       {
	    	 System.out.println("Divisione per zero non ammessa");
	    	 return 0;
	       }
	}
	
	/**
	 * Calcolo minimo
	 */
	private double min () throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
	 double Min=(double)m.invoke(af.get(0));
	 for (int i=0; i<af.size(); i++)
		{
		 if((double)m.invoke(af.get(i))<Min)
				Min=(double)m.invoke(af.get(i));
		}
	 return Min;
	}
	
	/**
	 * Calcolo massimo
	 */
	private double max () throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
	 double Max=(double)m.invoke(af.get(0));
	 for (int i=0; i<af.size(); i++)
		{
		 if((double)m.invoke(af.get(i))>Max)
				Max=(double)m.invoke(af.get(i));;
		}
	 return Max;
	}
	
	/**
	 * Calcolo deviazione standard
	 */
	private double devstd () throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
	 double Avg = avg();
	 double sum=0;
	 for(int i=0; i<af.size(); i++) 
		sum += (Math.pow((double)m.invoke(af.get(i))-Avg,2));
	 try { 
		  return Math.sqrt(sum/af.size());
	     } catch(ArithmeticException e)
	       {
		     System.out.println("Divisione per zero non ammessa");
		     return 0;
	       }
	}

	/**
	 * Calcolo numero elementi
	 */
	private long count () 
	{
	 return af.size();
	}
	
	/**
	 * Salvataggio di tutte le statistiche in un array
	 */
	public double[] getStat() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		arrStat[0]=sum();
		arrStat[1]=avg();
		arrStat[2]=min();
		arrStat[3]=max();
		arrStat[4]=devstd();
		arrStat[5]=count();
		return arrStat;
	}

}

