package marsmissionnasa.rest;

public class EndpointResponse {
	static final EndpointResponse VERB_NOT_SUPPORTED_ENDPOINT_RESPONSE;
	static final EndpointResponse ENDPOINT_NOT_SUPPORTED_ENDPOINT_RESPONSE;
	
	static {
		VERB_NOT_SUPPORTED_ENDPOINT_RESPONSE = new EndpointResponse();
		VERB_NOT_SUPPORTED_ENDPOINT_RESPONSE.setStatus(405);
		VERB_NOT_SUPPORTED_ENDPOINT_RESPONSE.setResponse("This http verb is not supported.");
		ENDPOINT_NOT_SUPPORTED_ENDPOINT_RESPONSE = new EndpointResponse();
		ENDPOINT_NOT_SUPPORTED_ENDPOINT_RESPONSE.setStatus(404);
		ENDPOINT_NOT_SUPPORTED_ENDPOINT_RESPONSE.setResponse("The URL is invalid.");
	}
	
	int status;
	String response;

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}
