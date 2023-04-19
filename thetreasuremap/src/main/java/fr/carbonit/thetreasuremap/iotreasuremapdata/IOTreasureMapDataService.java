/**
 * 
 */
package fr.carbonit.thetreasuremap.iotreasuremapdata;

import java.io.File;
import java.util.List;

/**
 * Service interface to implements actual and future service for input and output treasure map datas
 * @author jalavoine
 *
 */
public interface IOTreasureMapDataService {
	List<String> readDataFromTextFile(String inputFile);
	void writeResultsOnTextFile(List<String> resultLines, File outputFilePath, String outputFileName);
}
