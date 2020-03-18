package it.univpm.Project.utils;

import it.univpm.Project.dataset.Data;
import it.univpm.Project.dataset.Funding;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Classe utilizzata come servizio per la lettura di un json. Questo viene gestito mediante una lista
 * di vettori di oggetti
 * @author Cristian Cingolani & Christian Ascani
 */
 
public class JsonParser {
	private String dataset;
	private ArrayList<Funding> af;
	
	public JsonParser(String dataset)
	{
		this.dataset = dataset;
		this.af = Data.getArrFunding();
	}
	
	/**
	 * Memorizza le informazioni del dataset in un Arraylist di oggetti
	 */
	public void parse() throws Exception {
		FileReader reader = new FileReader(dataset);    //Reading the json file
		JSONParser jsonParser = new JSONParser();
		jsonParser.parse(reader);
        JSONObject jsonObject = new JSONObject();       //Creating a JSONObject
		for(Funding f : af) {                           //Iterating
		f = new Funding(
                (String) jsonObject.get("CodiceProgetto"),
                (String) jsonObject.get("CodiceCUP"),
                (String) jsonObject.get("TipologiaCUP"),
                (String) jsonObject.get("AmbitoRiferimento"),
                (String) jsonObject.get("DenominazioneProgetto"),
                (String) jsonObject.get("SintesiProgetto"),
                (String) jsonObject.get("UbicazioneProgetto"),
                (String) jsonObject.get("DataInizio"),
                (String) jsonObject.get("DataFinePrevista"),
                (String) jsonObject.get("DataFineEffettiva"),
                (String) jsonObject.get("ModalitaAttuativa"),
                (String) jsonObject.get("NomeBeneficiario"),
                (String) jsonObject.get("SedeLegaleBeneficiario"),
                (String) jsonObject.get("CodiceFiscaleBeneficiario"),
                Double.valueOf(jsonObject.get("CostoTotale").toString()),
                Double.valueOf(jsonObject.get("SpesaAmmissibile").toString()),
                Double.valueOf(jsonObject.get("QuotaUnioneEuropea").toString()),
                Double.valueOf(jsonObject.get("SpesaRealizzata").toString()),
                Double.valueOf(jsonObject.get("ImportoCertificato").toString()),
                Double.valueOf(jsonObject.get("ImportoLiquidato").toString()));
		
		af.add(f);                   //Filling the ArrayList
		}
		}
}