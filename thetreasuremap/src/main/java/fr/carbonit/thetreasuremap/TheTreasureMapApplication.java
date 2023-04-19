package fr.carbonit.thetreasuremap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.carbonit.thetreasuremap.treasuremap.treasuremapimpl.TreasureMapImpl;

@SpringBootApplication
public class TheTreasureMapApplication implements CommandLineRunner {

	private static final Logger LOGGER = LogManager.getLogger(TheTreasureMapApplication.class);
	
	@Value("${inputFilePath}")
	private String inputFile;
	
	@Value("${outputFilePath}")
	private String outputFile;
	
	@Value("${outpuFileName}")
	private String outputFileName;
	
	@Autowired
	TreasureMapImpl treasureMapImpl;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TheTreasureMapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (treasureMapImpl==null) {
			treasureMapImpl = new TreasureMapImpl();
		}
		//Le programme doit être capable de lire le fichier d'entrée de l'exercice
		treasureMapImpl.createTreasureMap(inputFile);
		
		//Le programme doit être capable d’exécuter les mouvements des différents aventuriers en respectant
//		
//		  les contraintes de l’exercice, de gérer la collecte des trésors et de
//		  restituer le résultat final de la simulation. Dans l’exemple précédent, Lara
//		  collecte 3 trésors et finit son parcours en (0 - 3).
		
//		Le programme doit être capable d’écrire un fichier contenant le résultat final de la simulation.
//		Note : une ligne débutant par un ‘#’ est un commentaire et doit être ignorée
		
		treasureMapImpl.sendResults(outputFile,outputFileName);
	}	
}
