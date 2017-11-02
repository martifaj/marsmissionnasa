package marsmissionnasa.domainlayer.entities;

import marsmissionnasa.domainlayer.Movement;
import marsmissionnasa.domainlayer.OutsidePlateauException;
import marsmissionnasa.domainlayer.Position;

public class Rover extends Entity {
	private Position position;
	
	public void move(Movement movement) throws OutsidePlateauException
	{
		position.applyMovement(movement);
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString()
	{
		return this.getId() + " " + position.toString();
	}
}
