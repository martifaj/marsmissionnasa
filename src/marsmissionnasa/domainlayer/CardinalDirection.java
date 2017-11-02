package marsmissionnasa.domainlayer;

public enum CardinalDirection {
	N(0, 0, 1),
	E(1, 1, 0),
	S(2, 0, -1),
	W(3, -1, 0);
	
	private int degree;
	private int displacementX;
	private int displacementY;

	private CardinalDirection(int degree, int displacementX, int displacementY)
	{
		this.degree = degree;
		this.displacementX = displacementX;
		this.displacementY = displacementY;
	}
	
	public static CardinalDirection valueOf(int degree)
	{
		CardinalDirection[] cardinalDirections = CardinalDirection.values();
		for (int i = 0; i < cardinalDirections.length; i++)
		{
			if (cardinalDirections[i].degree == degree)
			{
				return cardinalDirections[i];
			}
		}
		return N;
	}
	
	public CardinalDirection applyMovement(Movement movement)
	{
		int newDegree = this.degree + movement.getDegree() % CardinalDirection.values().length;
		if (newDegree < 0)
		{
			newDegree += CardinalDirection.values().length;
		}
		return CardinalDirection.valueOf(newDegree);
	}

	public int getDisplacementX() {
		return displacementX;
	}

	public int getDisplacementY() {
		return displacementY;
	}
}
