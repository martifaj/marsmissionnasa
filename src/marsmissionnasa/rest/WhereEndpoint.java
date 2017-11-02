package marsmissionnasa.rest;
import marsmissionnasa.servicelayer.InvalidRoverIdException;
import marsmissionnasa.servicelayer.MovementService;

public class WhereEndpoint extends Endpoint {
	private static final String PATH = "/where";

	private MovementService movementService;
	public WhereEndpoint(MovementService movementService)
	{
		this.movementService = movementService;
		this.path = PATH;
	}

	@Override
	protected EndpointResponse processPost(String roverId, String body) {
		return EndpointResponse.VERB_NOT_SUPPORTED_ENDPOINT_RESPONSE;
	}

	@Override
	protected EndpointResponse processGet(String roverId) {
		EndpointResponse endpointResponse = new EndpointResponse();
		String response;
		try {
			response = movementService.where(roverId);
			endpointResponse.setResponse(response);
			endpointResponse.setStatus(200);
		} catch (InvalidRoverIdException e) {
			endpointResponse.setResponse("Invalid rover id.");
			endpointResponse.setStatus(500);
		}
		return endpointResponse;
	}

}
