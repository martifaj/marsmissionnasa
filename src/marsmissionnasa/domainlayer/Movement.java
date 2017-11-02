package marsmissionnasa.domainlayer;

public enum Movement {
	L(-1, 0), R(1, 0), M(0, 1);
	
	private int degree;
	private int displacement;

	private Movement(int degree, int displacement)
	{
		this.degree = degree;
		this.displacement = displacement;
	}

	public int getDegree() {
		return degree;
	}
	public int getDisplacement() {
		return displacement;
	}
}
