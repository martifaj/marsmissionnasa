package marsmissionnasa.domainlayer;

public class Position {
	private int x;
	private int y;
	private CardinalDirection cardinalDirection;
	private Plateau plateau;

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public CardinalDirection getCardinalDirection() {
		return cardinalDirection;
	}
	public void setCardinalDirection(CardinalDirection cardinalDirection) {
		this.cardinalDirection = cardinalDirection;
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public void applyMovement(Movement movement) throws OutsidePlateauException
	{
		cardinalDirection = cardinalDirection.applyMovement(movement);
		x +=  movement.getDisplacement() * cardinalDirection.getDisplacementX();
		y +=  movement.getDisplacement() * cardinalDirection.getDisplacementY();
		checkPlateau();
	}
	
	private void checkPlateau() throws OutsidePlateauException
	{
		if (x < 0 || x > plateau.getUpperRightX() ||
			y < 0 || y > plateau.getUpperRightY())
		{
			throw new OutsidePlateauException();
		}
	}
	
	@Override
	public String toString()
	{
		return x + " " + y + " " + cardinalDirection.name();
	}
}
