package marsmissionnasa.servicelayer;

import java.util.List;

import marsmissionnasa.domainlayer.Movement;
import marsmissionnasa.domainlayer.MovementParser;
import marsmissionnasa.domainlayer.OutsidePlateauException;
import marsmissionnasa.domainlayer.dao.RoverDAO;
import marsmissionnasa.domainlayer.entities.Rover;

public class MovementService {
	
	private RoverDAO roverDAO;
	private MovementParser movementParser;
	public MovementService(RoverDAO roverDAO, MovementParser movementParser)
	{
		this.roverDAO = roverDAO;
		this.movementParser = movementParser;
	}

	public String move(String roverId, String movementText) throws InvalidRoverIdException, OutsidePlateauException
	{
		List<Movement> movements = movementParser.parse(movementText);
		Rover rover = roverDAO.read(roverId);
		if (rover == null)
		{
			throw new InvalidRoverIdException();
		}
		for (Movement currentMovement : movements)
		{
			rover.move(currentMovement);
		}
		return rover.getPosition().toString();
	}
	
	public String where(String roverId) throws InvalidRoverIdException
	{
		Rover rover = roverDAO.read(roverId);
		if (rover == null)
		{
			throw new InvalidRoverIdException();
		}
		return rover.getPosition().toString();
	}
}
