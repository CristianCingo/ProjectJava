package it.univpm.Project.dataset;

import java.util.ArrayList;

import it.univpm.Project.dataset.Funding;
import it.univpm.Project.dataset.Metadati;

/**
 * Classe contenente gli oggetti utili per la memorizzazione di dati e metadati
 */

public class Data {

	private static ArrayList<Funding> arrFunding = new ArrayList<Funding>();
	private static ArrayList<Metadati> arrMeta = new ArrayList<Metadati>();
	
	/**
	 * Costruttore utilizzato per la classe Data
	 */
	
	public Data()
	{
		arrFunding = new ArrayList<Funding>();
		arrMeta = new ArrayList<Metadati>();
		
		arrMeta.add(new Metadati("CodP", "CodiceProgetto", "string"));
		arrMeta.add(new Metadati("CodCUP", "CodiceCUP", "string"));
		arrMeta.add(new Metadati("TipCUP", "TipologiaCUP", "string"));
		arrMeta.add(new Metadati("AmbR", "AmbitoRiferimento", "string"));
		arrMeta.add(new Metadati("DenP", "DenominazioneProgetto", "string"));
		arrMeta.add(new Metadati("SinP", "SintesiProgetto", "string"));
		arrMeta.add(new Metadati("UbiP", "UbicazioneProgetto", "string"));
		arrMeta.add(new Metadati("DataI", "DataInizio", "string"));
		arrMeta.add(new Metadati("DataFP", "DataFinePrevista", "string"));
		arrMeta.add(new Metadati("DataFE", "DataFineEffettiva", "string"));
		arrMeta.add(new Metadati("ModAt", "ModalitaAttuativa", "string"));
		arrMeta.add(new Metadati("NomeB", "NomeBeneficiario", "string"));
		arrMeta.add(new Metadati("SedeLB", "SedeLegaleBeneficiario", "string"));
		arrMeta.add(new Metadati("CodFB", "CodiceFiscaleBeneficiario", "string"));
		arrMeta.add(new Metadati("CostoTot", "CostoTotale", "float"));
		arrMeta.add(new Metadati("SpesaAm", "SpesaAmmissibile", "float"));
		arrMeta.add(new Metadati("QuotaUE", "QuotaUnioneEuropea", "float"));
		arrMeta.add(new Metadati("SpesaR", "SpesaRealizzata", "float"));
		arrMeta.add(new Metadati("ImportoC", "ImportoCertificato", "float"));
		arrMeta.add(new Metadati("ImportoL", "ImportoLiquidato", "float"));
	}
	
	/**
	 * Metodo che restituisce arrFunding
	 */
	
	public static ArrayList<Funding> getArrFunding() {
		return arrFunding;
	}
	
	/**
	 * Metodo che restituisce arrMeta
	 */
	
	public static ArrayList<Metadati> getArrMeta() {
		return arrMeta;
	}
}
