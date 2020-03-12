package it.univpm.Project.exceptions;

import org.json.simple.JSONObject;

/**
 * Sottoclasse della superclasse JSONInvalidFilter che gestisce gli errori sulle chiavi
 * @author Cristian Cingolani e Christian Ascani
 *
 */
public class JSONInvalidKey extends JSONInvalidFilter  {
	/**
	 * Metodo che restituisce un messaggio di errore 
	 */
	@Override
	public String getMessage() {
		return "Errore, chiave del filtro non valida.";
	}

	/**
	 * Metodo che restituisce un JSONObject contenente l'errore
	 * @return oggetto JSON error
	 */
	public JSONObject getJSONError() {
		JSONObject error = new JSONObject();

		error.put("Errore", true);
		error.put("MessaggioErrore", this.getMessage());
		
		return error;
	}
}