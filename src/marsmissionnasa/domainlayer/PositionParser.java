package marsmissionnasa.domainlayer;

public class PositionParser {
	
	static final int POSITION_X = 0;
	static final int POSITION_Y = 1;
	static final int CARDINAL_DIRECTION = 2;
	
	public Position parse(String text)
	{
		String[] positionElements = text.split("\\s+");
		int positionX = Integer.parseInt(positionElements[POSITION_X]);
		int positionY = Integer.parseInt(positionElements[POSITION_Y]);
		CardinalDirection cardinalDirection = 
				CardinalDirection.valueOf(positionElements[CARDINAL_DIRECTION]);
		Position position = new Position();
		position.setX(positionX);
		position.setY(positionY);
		position.setCardinalDirection(cardinalDirection);
		return position;
	}
}
