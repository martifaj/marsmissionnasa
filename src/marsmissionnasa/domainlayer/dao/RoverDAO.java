package marsmissionnasa.domainlayer.dao;

import marsmissionnasa.domainlayer.entities.Rover;
import marsmissionnasa.domainlayer.indices.RoverIdIndex;

public class RoverDAO extends BaseEntityDAO<Rover> {
	public RoverDAO(RoverIdIndex roverIdIndex) {
		super(roverIdIndex);
	}
}
