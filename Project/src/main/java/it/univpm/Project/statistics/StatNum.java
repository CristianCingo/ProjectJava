package it.univpm.Project.statistics;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import it.univpm.Project.dataset.Funding;

/**
 * Calcoliamo le statistiche
 */

public class StatNum extends StatBasic{

	private double arrStat[] = new double[6];
	public StatNum(String param, ArrayList<Funding> af) throws NoSuchMethodException, SecurityException
	{
		super(param, af);
	}
	
	private double sum () throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		double sum=0;
		for (int i=0; i<af.size(); i++)
		{
			sum += (double)m.invoke(af.get(i));
		}
				
			return (sum);
		}
	
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

	private long count () 
	{
	 return af.size();
	}
	
	
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

