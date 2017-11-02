package marsmissionnasa.rest;
import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class RestServer {
	private HttpServer server;

	public RestServer(int port) throws IOException
	{
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(null); // creates a default executor
	}
	
	public void start()
	{
		server.start();
	}
	
	public void stop()
	{
		server.stop(1);
	}

	public void addEnpoint(Endpoint endpoint)
	{
        server.createContext(endpoint.getPath(), endpoint);
	}
}
