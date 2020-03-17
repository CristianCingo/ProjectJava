package it.univpm.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.Project.dataset.Data;
import it.univpm.Project.utils.*;

@SpringBootApplication
public class ProjectApplication {
	
	/**
	 * Main del programma. Inizialmente si istanzia un oggetto della classe  per scaricare il json e il 
	 * file json contenete i dati. Successivamente si avvia la spring application.
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
			
		JsonGetDecode dd = new JsonGetDecode("https://www.dati.gov.it/api/3/action/package_show?id=bb6a09a7-af75-4fa5-805f-ed38eda6e883");
			
			if (dd.readFile()) {
				Data d = new Data();
				JsonParser p = new JsonParser("dataFile.json");
				p.readFile();
			}
			
			else System.out.println("Impossibile avviare l'applicazione: il Dataset non è stato trovato.");
			SpringApplication.run(ProjectApplication.class, args);
			
	}

}
