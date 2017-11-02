package marsmissionnasa.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public abstract class Endpoint implements HttpHandler {
	protected String path;

    @Override
    public void handle(HttpExchange t) throws IOException {
    	EndpointResponse endpointResponse;
		String fullPath = t.getRequestURI().getPath();
		String[] pathElements = fullPath.split("/");
		List<String> pathElementsWithoutLast = new LinkedList<String>(Arrays.asList(pathElements));
		String roverId = pathElementsWithoutLast.remove(pathElements.length - 1);
		String reconstructedPath = String.join("/", pathElementsWithoutLast);
		if (reconstructedPath.equals(path))
		{
			if (t.getRequestMethod().equals("GET"))
	    	{
				endpointResponse = processGet(roverId);
	    	}
	    	else if (t.getRequestMethod().equals("POST"))
	    	{
	    		InputStream is = t.getRequestBody();
	    		String body = new BufferedReader(new InputStreamReader(is))
	    				  .lines().collect(Collectors.joining("\n"));
	    		endpointResponse = processPost(roverId, body);
	    	}
	    	else
	    	{
	    		endpointResponse = EndpointResponse.VERB_NOT_SUPPORTED_ENDPOINT_RESPONSE;
	    	}
		}
		else
		{
			endpointResponse = EndpointResponse.ENDPOINT_NOT_SUPPORTED_ENDPOINT_RESPONSE;
		}
    	
        t.sendResponseHeaders(endpointResponse.getStatus(), endpointResponse.getResponse().length());
        OutputStream os = t.getResponseBody();
        os.write(endpointResponse.getResponse().getBytes());
        os.close();
    }
    
    protected abstract EndpointResponse processPost(String roverId, String body);
    protected abstract EndpointResponse processGet(String roverId);
    
	public String getPath() {
		return path;
	}
    
    
}
