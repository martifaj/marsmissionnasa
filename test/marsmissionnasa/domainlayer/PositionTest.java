package marsmissionnasa.domainlayer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import marsmissionnasa.domainlayer.CardinalDirection;
import marsmissionnasa.domainlayer.Movement;
import marsmissionnasa.domainlayer.OutsidePlateauException;
import marsmissionnasa.domainlayer.Plateau;
import marsmissionnasa.domainlayer.Position;

public class PositionTest {

	@Test(expected = OutsidePlateauException.class) 
	public void outsidePlateau() throws OutsidePlateauException
	{
		Plateau plateau = new Plateau();
		plateau.setUpperRightX(2);
		plateau.setUpperRightY(2);
		Position position = new Position();
		position.setCardinalDirection(CardinalDirection.N);
		position.setPlateau(plateau);
		position.setX(2);
		position.setY(2);
		position.applyMovement(Movement.M);
	}
	
	@Test
	public void moveN() throws OutsidePlateauException
	{
		Plateau plateau = new Plateau();
		plateau.setUpperRightX(4);
		plateau.setUpperRightY(4);
		Position position = new Position();
		position.setCardinalDirection(CardinalDirection.N);
		position.setPlateau(plateau);
		position.setX(2);
		position.setY(2);
		position.applyMovement(Movement.M);
		assertEquals(2, position.getX());
		assertEquals(3, position.getY());
	}
	
	@Test
	public void moveS() throws OutsidePlateauException
	{
		Plateau plateau = new Plateau();
		plateau.setUpperRightX(4);
		plateau.setUpperRightY(4);
		Position position = new Position();
		position.setCardinalDirection(CardinalDirection.S);
		position.setPlateau(plateau);
		position.setX(2);
		position.setY(2);
		position.applyMovement(Movement.M);
		assertEquals(2, position.getX());
		assertEquals(1, position.getY());
	}
	
	@Test
	public void moveW() throws OutsidePlateauException
	{
		Plateau plateau = new Plateau();
		plateau.setUpperRightX(4);
		plateau.setUpperRightY(4);
		Position position = new Position();
		position.setCardinalDirection(CardinalDirection.W);
		position.setPlateau(plateau);
		position.setX(2);
		position.setY(2);
		position.applyMovement(Movement.M);
		assertEquals(1, position.getX());
		assertEquals(2, position.getY());
	}
	
	@Test
	public void moveE() throws OutsidePlateauException
	{
		Plateau plateau = new Plateau();
		plateau.setUpperRightX(4);
		plateau.setUpperRightY(4);
		Position position = new Position();
		position.setCardinalDirection(CardinalDirection.E);
		position.setPlateau(plateau);
		position.setX(2);
		position.setY(2);
		position.applyMovement(Movement.M);
		assertEquals(3, position.getX());
		assertEquals(2, position.getY());
	}
}
