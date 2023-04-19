/**
 * 
 */
package fr.carbonit.thetreasuremap.iotreasuremapdata.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import fr.carbonit.thetreasuremap.iotreasuremapdata.IOTreasureMapDataService;

/**
 * Bean component managing reading data from input and writing on output
 * @author jalavoine
 *
 */
@Service
public class IOTreasureMapDataImpl implements IOTreasureMapDataService{
	
	private static final Logger LOGGER = LogManager.getLogger(IOTreasureMapDataService.class);
	
	@Override
	public List<String> readDataFromTextFile(String inputFile) {
			List<String> lines = new ArrayList<>();
			BufferedReader br=null;
			String line;
			try {
				br = new BufferedReader(new FileReader(inputFile));
				while((line = br.readLine())!=null) {
					lines.add(line);
				}
			} catch (FileNotFoundException e) {
				LOGGER.error("INPUT FILE " + inputFile +" NOT FOUND");
				e.printStackTrace();
			} catch (IOException e) {
				LOGGER.error("IOEXCEPTION in class " + getClass().getCanonicalName());
				e.printStackTrace();
			} finally {
				try {
					if(br != null) {
						br.close();
					}
				}catch (IOException e) {
						LOGGER.error("IOEXCEPTION trying closing BufferedReader in class " + getClass().getCanonicalName());
						e.printStackTrace();
					}
				}
			
			LOGGER.info("Datas from textFile extracts into lines");
			return lines;
	}
	
	@Override
	public void writeResultsOnTextFile(List<String> resultLines, File outputFile, String outputFileName) {
		if(! outputFile.exists()) {
			outputFile.mkdir();
		}
		
		File textOutputFile = new File(outputFile + "\\" +  outputFileName);
		
		try (FileWriter wr = new FileWriter(textOutputFile)) {
			resultLines.stream().forEach((line) -> {
				LOGGER.info(line.toString());
					try {
						wr.write(line + "\n");
					} catch (IOException e) {
						LOGGER.error("IOException on writing results in file in class: " + getClass().getCanonicalName());
						e.printStackTrace();
					}
			});
		} catch (IOException e) {
			LOGGER.error("IOException on writing results in file in class: " + getClass().getCanonicalName());
			e.printStackTrace();
		} 
	}
}
