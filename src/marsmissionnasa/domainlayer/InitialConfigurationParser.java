package marsmissionnasa.domainlayer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InitialConfigurationParser {
	private PlateauParser plateauParser;
	private RoverParser roverParser;
	
	public InitialConfigurationParser(PlateauParser plateauParser,
									  RoverParser roverParser)
	{
		this.plateauParser = plateauParser;
		this.roverParser = roverParser;
	}
	
	public void parse(String fileName) throws OutsidePlateauException
	{
		try (FileReader fr = new FileReader(fileName);
		     BufferedReader br = new BufferedReader(fr))
		{
			String currentLine;
			if ((currentLine = br.readLine()) != null) {
				Plateau plateau = plateauParser.parse(currentLine);
				roverParser.setPlateau(plateau);
				while ((currentLine = br.readLine()) != null) {
					roverParser.parse(currentLine);
				}	
			}
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: File doesn't exist.");
		} catch (IOException e) {
			System.err.println("ERROR: IO.");
		}
	}
}
