package marsmissionnasa.domainlayer;

public class PlateauParser {
	static final int UPPER_RIGHT_X = 0;
	static final int UPPER_RIGHT_Y = 1;
	
	public Plateau parse(String text)
	{
		String[] plateauElements = text.split("\\s+");
		Plateau plateau = new Plateau();
		int upperRightX = Integer.parseInt(plateauElements[UPPER_RIGHT_X]);
		int upperRightY = Integer.parseInt(plateauElements[UPPER_RIGHT_Y]);
		plateau.setUpperRightX(upperRightX);
		plateau.setUpperRightY(upperRightY);
		return plateau;
	}
}
