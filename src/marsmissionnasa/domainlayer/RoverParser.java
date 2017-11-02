package marsmissionnasa.domainlayer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import marsmissionnasa.domainlayer.dao.RoverDAO;
import marsmissionnasa.domainlayer.entities.Rover;

public class RoverParser {
	static final int IDENTIFIER_INDEX = 0;
	static final int[] POSITION_INDEX = {1,2,3};
	static final int MOVEMENT_INDEX   = 4;
	
	private PositionParser positionParser;
	private MovementParser movementParser;
	private Plateau plateau;
	private RoverDAO roverDAO;
	
	public RoverParser(PositionParser positionParser,
					   MovementParser movementParser,
					   RoverDAO roverDAO)
	{
		this.positionParser = positionParser;
		this.movementParser = movementParser;
		this.roverDAO = roverDAO;
	}
	
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public Rover parse(String text) throws OutsidePlateauException
	{
		String[] roverElements = text.split("\\s+");
		List<String> positionElements = new LinkedList<String>(Arrays.asList(roverElements));
		positionElements.remove(MOVEMENT_INDEX);
		positionElements.remove(IDENTIFIER_INDEX);
		Position position = positionParser.parse(String.join(" ", positionElements));
		position.setPlateau(plateau);
		Rover rover = new Rover();
		rover.setId(roverElements[IDENTIFIER_INDEX]);
		rover.setPosition(position);
		roverDAO.create(rover);
		List<Movement> movements = movementParser.parse(roverElements[MOVEMENT_INDEX]);
		for (Movement movement : movements)
		{
			rover.move(movement);
		}
		return rover;
	}
}
