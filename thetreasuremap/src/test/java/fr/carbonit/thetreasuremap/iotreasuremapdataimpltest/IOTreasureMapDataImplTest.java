/**
 * 
 */
package fr.carbonit.thetreasuremap.iotreasuremapdataimpltest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import fr.carbonit.thetreasuremap.iotreasuremapdata.impl.IOTreasureMapDataImpl;

/**
 * class test for input and output reader
 * @author jalavoine
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class IOTreasureMapDataImplTest {
	
	private static final Logger LOGGER = LogManager.getLogger(IOTreasureMapDataImplTest.class);
	
	@Autowired
	IOTreasureMapDataImpl ioTreasureDataImpl;
	
	@Value("${inputFilePath}")
	private String inputFile;
	
	@Value("${outputFilePath}")
	private String outputFile;
	
	@Value("${outpuFileName}")
	private String outputFileName;
	
	@BeforeAll
	void setup() {
		ioTreasureDataImpl = new IOTreasureMapDataImpl();

	}
	
	@Test
	void testReadDataFromTextFile() {
		ioTreasureDataImpl.readDataFromTextFile(inputFile).stream().forEach(
				line -> {
					LOGGER.info(line.toString());
				});
	}
	
	@Test
	void writeResultsInTextFile() {
		File output = new File(outputFile);
		String fileName = "results";
		List<String> results = new ArrayList<>();
		String line1 = "C - 3 - 4";
		results.add(line1);
		String line2 = "M - 1 - 1";
		results.add(line2);
		String line3 = "M - 2 - 2";
		results.add(line3);
		String line4 = "T - 0 - 3 - 2";
		results.add(line4);
		String line5 = "T - 1 - 3 - 1";
		results.add(line5);
		String line6 = "A - Indiana - 2 - 1 - S - 4";
		results.add(line6);
		System.out.println(results.toString());
		
		ioTreasureDataImpl.writeResultsOnTextFile(results, output, fileName);
	}
}
