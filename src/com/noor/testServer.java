package com.noor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import javax.xml.ws.http.HTTPException;

import org.apache.catalina.connector.Response;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class testServer {

	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8350), 0);
		server.createContext("/", new wsHandler());
		/*
		 * All HTTP requests are handled in tasks given to the executor.
		 */
		server.setExecutor(null);
		server.start();
	}
	
	
	
	static class wsHandler implements HttpHandler{
		 @Override
		 public void handle(HttpExchange v) throws IOException{
			 String response = "hello world!";
			 v.sendResponseHeaders(200, response.getBytes().length);
			 OutputStream outstr = v.getResponseBody();
			 outstr.write(response.getBytes());
			 outstr.close();
			 
		 }
	}
}
