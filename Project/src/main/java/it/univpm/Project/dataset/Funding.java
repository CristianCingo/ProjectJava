package it.univpm.Project.dataset;

public class Funding {
	
		public String CodP;
		public String CodCUP;
		public String TipCUP;
		public String AmbR;
		public String DenP;
		public String SinP;
		public String UbiP;
		public String DataI;
		public String DataFP;
		public String DataFE;
		public String ModAt;
		public String NomeB;
		public String SedeLB;
		public String CodFB;
		public double CostoTot;
		public double SpesaAm;
		public double QuotaUE;
		public double SpesaR;
		public double ImportoC;
		public double ImportoL;
		
		/**
		 * Costruttore della classe Funding
		* @param CodiceProgetto;
		* @param CodiceCUP;
		* @param TipologiaCUP;
		* @param AmbitoRiferimento;
		* @param DenominazioneProgetto;
		* @param SintesiProgetto;
		* @param UbicazioneProgetto;
		* @param DataInizio;
		* @param DataFinePrevista;
		* @param DataFineEffettiva;
		* @param ModalitaAttuativa;
		* @param NomeBeneficiario;
		* @param SedeLegaleBeneficiario;
		* @param CodiceFiscaleBeneficiario;
		* @param CostoTotale;
		* @param SpesaAmmissibile;
		* @param QuotaUnioneEuropea;
		* @param SpesaRealizzata;
		* @param ImportoCertificato;
		* @param ImportoLiquidato;
		 */
		public Funding(String CodiceProgetto,String CodiceCUP,String TipologiaCUP,String AmbitoRiferimento,
				String DenominazioneProgetto,String SintesiProgetto,String UbicazioneProgetto,
				String DataInizio,String DataFinePrevista,String DataFineEffettiva,String ModalitaAttuativa,
				String NomeBeneficiario,String SedeLegaleBeneficiario,String CodiceFiscaleBeneficiario,
				double CostoTotale,double SpesaAmmissibile,double QuotaUnioneEuropea,double SpesaRealizzata,
				double ImportoCertificato,double ImportoLiquidato) {
			
			this.CodP = CodiceProgetto;
			this.CodCUP = CodiceCUP;
			this.TipCUP = TipologiaCUP;
			this.AmbR = AmbitoRiferimento;
			this.DenP = DenominazioneProgetto;
			this.SinP = SintesiProgetto;
			this.UbiP = UbicazioneProgetto;
			this.DataI = DataInizio;
			this.DataFP = DataFinePrevista;
			this.DataFE = DataFineEffettiva;
			this.ModAt = ModalitaAttuativa;
			this.NomeB = NomeBeneficiario;
			this.SedeLB = SedeLegaleBeneficiario;
			this.CodFB = CodiceFiscaleBeneficiario;
			this.CostoTot = CostoTotale;
			this.SpesaAm = SpesaAmmissibile;
			this.QuotaUE = QuotaUnioneEuropea;
			this.SpesaR = SpesaRealizzata;
			this.ImportoC = ImportoCertificato;
			this.ImportoL = ImportoLiquidato;
		}
		
		/**
		 * Costruttore vuoto della classe Funding
		 */
		public Funding() {
			
		}
		
		/**
		 * Metodo che restituisce CodiceProgetto
		 * @return CodiceProgetto
		 */
		
		public String getCodiceProgetto() {
			return CodP;
		}

		/**
		 * Metodo che restituisce CodiceCUP
		 * @return CodiceCUP
		 */
		
		public String getCodiceCUP() {
			return CodCUP;
		}

		/**
		 * Metodo che restituisce TipologiaCUP
		 * @return TipologiaCUP
		 */
		
		public String getTipologiaCUP() {
			return TipCUP;
		}

		/**
		 * Metodo che restituisce AmbitoRiferimento
		 * @return AmbitoRiferimento
		 */
		
		public String getAmbitoRiferimento() {
			return AmbR;
		}

		/**
		 * Metodo che restituisce DenominazioneProgetto
		 * @return DenominazioneProgetto
		 */
		
		public String getDenominazioneProgetto() {
			return DenP;
		}

		/**
		 * Metodo che restituisce SintesiProgetto
		 * @return SintesiProgetto
		 */
		
		public String getSintesiProgetto() {
			return SinP;
		}

		/**
		 * Metodo che restituisce UbicazioneProgetto
		 * @return UbicazioneProgetto
		 */
		
		public String getUbicazioneProgetto() {
			return UbiP;
		}

		/**
		 * Metodo che restituisce DataInizio
		 * @return DataInizio
		 */
		
		public String getDataInizio() {
			return DataI;
		}

		/**
		 * Metodo che restituisce DataFinePrevista
		 * @return DataFinePrevista
		 */
		
		public String getDataFinePrevista() {
			return DataFP;
		}

		/**
		 * Metodo che restituisce DataFineEffettiva
		 * @return DataFineEffettiva
		 */
		
		public String getDataFineEffettiva() {
			return DataFE;
		}

		/**
		 * Metodo che restituisce ModalitaAttuativa
		 * @return ModalitaAttuativa
		 */
		
		public String getModalitaAttuativa() {
			return ModAt;
		}

		/**
		 * Metodo che restituisce NomeBeneficiario
		 * @return NomeBeneficiario
		 */
		
		public String getNomeBeneficiario() {
			return NomeB;
		}

		/**
		 * Metodo che restituisce SedeLegaleBeneficiario
		 * @return SedeLegaleBeneficiario
		 */
		
		public String getSedeLegaleBeneficiario() {
			return SedeLB;
		}

		/**
		 * Metodo che restituisce CodiceFiscaleBeneficiario
		 * @return CodiceFiscaleBeneficiario
		 */
		
		public String getCodiceFiscaleBeneficiario() {
			return CodFB;
		}

		/**
		 * Metodo che restituisce CostoTotale
		 * @return CostoTotale
		 */
		
		public double getCostoTotale() {
			return CostoTot;
		}

		/**
		 * Metodo che restituisce SpesaAmmissibile
		 * @return SpesaAmmissibile
		 */
		
		public double getSpesaAmmissibile() {
			return SpesaAm;
		}

		/**
		 * Metodo che restituisce QuotaUnioneEuropea
		 * @return QuotaUnioneEuropea
		 */
		
		public double getQuotaUnioneEuropea() {
			return QuotaUE;
		}

		/**
		 * Metodo che restituisce SpesaRealizzata
		 * @return SpesaRealizzata
		 */
		
		public double getSpesaRealizzata() {
			return SpesaR;
		}
		
		/**
		 * Metodo che restituisce ImportoCertificato
		 * @return ImportoCertificato
		 */
		
		public double getImportoCertificato() {
			return ImportoC;
		}
		
		/**
		 * Metodo che restituisce ImportoLiquidato
		 * @return ImportoLiquidato
		 */
		
		public double getImportoLiquidato() {
			return ImportoL;
		}
		
		/**
		 * Metodo che imposta il valore di CodiceProgetto
		 * @param CodiceProgetto
		 */
		
		public void setCodiceProgetto(String CodiceProgetto) {
			this.CodP = CodiceProgetto;
		}

		/**
		 * Metodo che imposta il valore di CodiceCUP
		 * @param CodiceCUP
		 */
		
		public void setCodiceCUP(String CodiceCUP) {
			this.CodCUP = CodiceCUP;
		}

		/**
		 * Metodo che imposta il valore di TipologiaCUP
		 * @param TipologiaCUP
		 */
		
		public void setTipologiaCUP(String TipologiaCUP) {
			this.TipCUP = TipologiaCUP;
		}

		/**
		 * Metodo che imposta il valore di AmbitoRiferimento
		 * @param AmbitoRiferimento
		 */
		
		public void setAmbitoRiferimento(String AmbitoRiferimento) {
			this.AmbR = AmbitoRiferimento;
		}

		/**
		 * Metodo che imposta il valore di DenominazioneProgetto
		 * @param DenominazioneProgetto
		 */
		
		public void setDenominazioneProgetto(String DenominazioneProgetto) {
			this.DenP = DenominazioneProgetto;
		}

		/**
		 * Metodo che imposta il valore di SintesiProgetto
		 * @param SintesiProgetto
		 */
		
		public void setSintesiProgetto(String SintesiProgetto) {
			this.SinP = SintesiProgetto;
		}

		/**
		 * Metodo che imposta il valore di UbicazioneProgetto
		 * @param UbicazioneProgetto
		 */
		
		public void setUbicazioneProgetto(String UbicazioneProgetto) {
			this.UbiP = UbicazioneProgetto;
		}

		/**
		 * Metodo che imposta il valore di DataInizio
		 * @param DataInizio
		 */
		
		public void setDataInizio(String DataInizio) {
			this.DataI = DataInizio;
		}

		/**
		 * Metodo che imposta il valore di DataFinePrevista
		 * @param DataFinePrevista
		 */
		
		public void setDataFinePrevista(String DataFinePrevista) {
			this.DataFP = DataFinePrevista;
		}

		/**
		 * Metodo che imposta il valore di DataFineEffettiva
		 * @param DataFineEffettiva
		 */
		
		public void setDataFineEffettiva(String DataFineEffettiva) {
			this.DataFE = DataFineEffettiva;
		}

		/**
		 * Metodo che imposta il valore di ModalitaAttuativa
		 * @param ModalitaAttuativa
		 */
		
		public void setModalitaAttuativa(String ModalitaAttuativa) {
			this.ModAt = ModalitaAttuativa;
		}

		/**
		 * Metodo che imposta il valore di NomeBeneficiario
		 * @param NomeBeneficiario
		 */
		
		public void setNomeBeneficiario(String NomeBeneficiario) {
			this.NomeB = NomeBeneficiario;
		}

		/**
		 * Metodo che imposta il valore di SedeLegaleBeneficiario
		 * @param SedeLegaleBeneficiario
		 */
		
		public void setSedeLegaleBeneficiario(String SedeLegaleBeneficiario) {
			this.SedeLB = SedeLegaleBeneficiario;
		}

		/**
		 * Metodo che imposta il valore di CodiceFiscaleBeneficiario
		 * @param CodiceFiscaleBeneficiario
		 */
		
		public void setCodiceFiscaleBeneficiario(String CodiceFiscaleBeneficiario) {
			this.CodFB = CodiceFiscaleBeneficiario;
		}

		/**
		 * Metodo che imposta il valore di CostoTotale
		 * @param CostoTotale
		 */
		
		public void setCostoTotale(double CostoTotale) {
			this.CostoTot = CostoTotale;
		}

		/**
		 *Metodo che imposta il valore di SpesaAmmissibile
		 * @param SpesaAmmissibile
		 */
		
		public void setSpesaAmmissibile(double SpesaAmmissibile) {
			this.SpesaAm = SpesaAmmissibile;
		}

		/**
		 * Metodo che imposta il valore di QuotaUnioneEuropea
		 * @param QuotaUnioneEuropea
		 */
		
		public void setQuotaUnioneEuropea(double QuotaUnioneEuropea) {
			this.QuotaUE = QuotaUnioneEuropea; 
		}

		/**
		 * Metodo che imposta il valore di SpesaRealizzata
		 * @param SpesaRealizzata
		 */
		
		public void setSpesaRealizzata(double SpesaRealizzata) {
			this.SpesaR = SpesaRealizzata;
		}
		
		/**
		 * Metodo che imposta il valore di ImportoCertificato
		 * @param ImportoCertificato
		 */
		
		public void setImportoCertificato(double ImportoCertificato) {
			this.ImportoC = ImportoCertificato;
		}
		
		/**
		 * Metodo che imposta il valore di ImportoLiquidato
		 * @param ImportoLiquidato
		 */
		
		public void setImportoLiquidato(double ImportoLiquidato) {
			this.ImportoL = ImportoLiquidato;
		}
}



