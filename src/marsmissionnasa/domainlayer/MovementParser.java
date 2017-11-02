package marsmissionnasa.domainlayer;

import java.util.ArrayList;
import java.util.List;

public class MovementParser {
	public List<Movement> parse(String text)
	{
		List<Movement> movements = new ArrayList<>(text.length());
		for (int i = 0; i < text.length(); i++)
		{
			movements.add(Movement.valueOf(text.substring(i, i + 1)));
		}
		return movements;
	}
}
