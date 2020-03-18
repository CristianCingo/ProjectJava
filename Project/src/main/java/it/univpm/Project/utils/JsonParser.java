package it.univpm.Project.utils;

import it.univpm.Project.dataset.Data;
import it.univpm.Project.dataset.Funding;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
	private String dataset;
	private ArrayList<Funding> af;
	
	public JsonParser(String dataset)
	{
		this.dataset=dataset;
		this.af = Data.getArrFunding();
	}
	
	public void readFile() {
		
		
	try (BufferedReader br = new BufferedReader(new FileReader(dataset))){
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Funding>> typeReference = new TypeReference<List<Funding>>() {};
		List<Funding> fundings = mapper.readValue(br, typeReference);
	 {
			String CodP = (String) ((Funding) fundings).getCodiceProgetto();
			String CodCUP = (String) ((Funding) fundings).getCodiceCUP();
			String TipCUP = (String) ((Funding) fundings).getTipologiaCUP();
			String AmbR = (String) ((Funding) fundings).getAmbitoRiferimento();
			String DenP = (String) ((Funding) fundings).getDenominazioneProgetto();
			String SinP = (String) ((Funding) fundings).getSintesiProgetto();
			String UbiP = (String) ((Funding) fundings).getUbicazioneProgetto();
			String DataI = (String) ((Funding) fundings).getDataInizio();
			String DataFP = (String) ((Funding) fundings).getDataFinePrevista();
			String DataFE = (String) ((Funding) fundings).getDataFineEffettiva();
			String ModAt = (String) ((Funding) fundings).getModalitaAttuativa();
			String NomeB = (String) ((Funding) fundings).getNomeBeneficiario();
			String SedeLB = (String) ((Funding) fundings).getSedeLegaleBeneficiario();
			String CodFB = (String) ((Funding) fundings).getCodiceFiscaleBeneficiario();
			float CostoTot = (float) ((Funding) fundings).getCostoTotale();
			float SpesaAm = (float) ((Funding) fundings).getSpesaAmmissibile();
			float QuotaUE = (float) ((Funding) fundings).getQuotaUnioneEuropea();
			float SpesaR = (float) ((Funding) fundings).getSpesaRealizzata();
			float ImportoC = (float) ((Funding) fundings).getImportoCertificato();
			float ImportoL = (float) ((Funding) fundings).getImportoLiquidato();
			
			
			af.add(new Funding(CodP, CodCUP, TipCUP, AmbR, DenP, SinP, UbiP, DataI, DataFP, DataFE, ModAt, NomeB, SedeLB, CodFB, CostoTot, SpesaAm, QuotaUE, SpesaR, ImportoC, ImportoL));
		}

	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch (JsonParseException ex) {
		ex.printStackTrace();
	}
	catch (JsonMappingException e) {
		e.printStackTrace();
	}
	catch (IOException ex) {
		ex.printStackTrace();
	}
}
}