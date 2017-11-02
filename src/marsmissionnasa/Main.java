package marsmissionnasa;
import java.io.IOException;
import java.util.List;

import marsmissionnasa.domainlayer.InitialConfigurationParser;
import marsmissionnasa.domainlayer.MovementParser;
import marsmissionnasa.domainlayer.OutsidePlateauException;
import marsmissionnasa.domainlayer.PlateauParser;
import marsmissionnasa.domainlayer.PositionParser;
import marsmissionnasa.domainlayer.RoverParser;
import marsmissionnasa.domainlayer.dao.RoverDAO;
import marsmissionnasa.domainlayer.entities.Rover;
import marsmissionnasa.domainlayer.indices.RoverIdIndex;
import marsmissionnasa.rest.MoveEndpoint;
import marsmissionnasa.rest.RestServer;
import marsmissionnasa.rest.WhereEndpoint;
import marsmissionnasa.servicelayer.InvalidRoverIdException;
import marsmissionnasa.servicelayer.MovementService;

public class Main {
	static final int PORT = 8081;
	static final String CONFIGURATION_FILE_NAME = "MarsMissionNASA.txt";
	
	public static void main(String[] args) throws IOException, InvalidRoverIdException, OutsidePlateauException {
		RoverIdIndex roverIdIndex = new RoverIdIndex();
		RoverDAO roverDAO = new RoverDAO(roverIdIndex);
		PositionParser positionParser = new PositionParser();
		MovementParser movementParser = new MovementParser();
		RoverParser roverParser = new RoverParser(positionParser,
												  movementParser,
												  roverDAO);
		PlateauParser plateauParser = new PlateauParser();
		InitialConfigurationParser initialConfigurationParser = 
				new InitialConfigurationParser(plateauParser, roverParser);
		initialConfigurationParser.parse(CONFIGURATION_FILE_NAME);
		RestServer roverRestServer = new RestServer(PORT);
		MovementService movementService = new MovementService(roverDAO, movementParser);
		List<Rover> rovers = roverDAO.readAll();
		for (Rover rover : rovers)
		{
			System.out.println(rover.getId() + " " + movementService.where(rover.getId()));
		}
		MoveEndpoint moveEndpoint = new MoveEndpoint(movementService);
		WhereEndpoint whereEndpoint = new WhereEndpoint(movementService);
		roverRestServer.addEnpoint(moveEndpoint);
		roverRestServer.addEnpoint(whereEndpoint);
		roverRestServer.start();
	}
}
