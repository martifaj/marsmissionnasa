package marsmissionnasa.rest;
import marsmissionnasa.domainlayer.OutsidePlateauException;
import marsmissionnasa.servicelayer.InvalidRoverIdException;
import marsmissionnasa.servicelayer.MovementService;

public class MoveEndpoint extends Endpoint {
	private static final String PATH = "/move";
	
	private MovementService movementService;
	public MoveEndpoint(MovementService movementService)
	{
		this.movementService = movementService;
		this.path = PATH;
	}

	@Override
	protected EndpointResponse processPost(String roverId, String body) {
		EndpointResponse endpointResponse = new EndpointResponse();
		String response;
		try {
			response = movementService.move(roverId, body);
			endpointResponse.setResponse(response);
			endpointResponse.setStatus(200);
		} catch (InvalidRoverIdException e) {
			endpointResponse.setResponse("Invalid rover id.");
			endpointResponse.setStatus(500);
		} catch (OutsidePlateauException e) {
			endpointResponse.setResponse("The rover has exited the plateau.");
			endpointResponse.setStatus(500);
		}

		return endpointResponse;
	}

	@Override
	protected EndpointResponse processGet(String parameters) {
		return EndpointResponse.VERB_NOT_SUPPORTED_ENDPOINT_RESPONSE;
	}

}
