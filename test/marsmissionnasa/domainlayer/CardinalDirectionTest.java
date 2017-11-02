package marsmissionnasa.domainlayer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import marsmissionnasa.domainlayer.CardinalDirection;
import marsmissionnasa.domainlayer.Movement;

public class CardinalDirectionTest {

	@Test
	public void rotateLeft()
	{
		CardinalDirection cardinalDirection = 
				CardinalDirection.N.applyMovement(Movement.L);
		assertEquals(CardinalDirection.W, cardinalDirection);
	}
	
	@Test
	public void rotateRight()
	{
		CardinalDirection cardinalDirection = 
				CardinalDirection.N.applyMovement(Movement.R);
		assertEquals(CardinalDirection.E, cardinalDirection);
	}
	
	@Test
	public void moveForward()
	{
		CardinalDirection cardinalDirection = 
				CardinalDirection.N.applyMovement(Movement.M);
		assertEquals(CardinalDirection.N, cardinalDirection);
	}
}
