package it.univpm.Project.dataset;
/**
 * Classe che descrive l'oggetto Metadati composto da 3 informazioni essenziali: alias (nome del campo), 
 * sourceField (descrizione del campo) e type (tipo del campo). 
 * @author Cristian Cingolani & Christian Ascani
 */
public class Metadati {
private String alias, sourceF, type;

    /**
     Costruttore di Metadati
	 * @param alias, Parametro che rappresenta il nome di un campo
	 * @param sourceField, Parametro che rappresenta la descrizione del campo
	 * @param type, Parametro che rappresenta il tipo del campo
    */

	public Metadati(String alias, String sourceField, String type)
	{
		this.alias = alias;
		this.sourceF = sourceField;
		this.type = type;
	}
	
	/**
	 * Getter dei parametri sopra passati
	 * 
	 * 
	 */
	public String getAlias() {
		return alias;
	}

	public String getSourceField() {
		return sourceF;
	}

	public String getType() {
		return type;
	}

}
