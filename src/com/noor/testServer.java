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
		//create server in order to associate server --> port is defined here (port,backlog)
		HttpServer server = HttpServer.create(new InetSocketAddress(8300), 0);
		server.createContext("/test", new wsHandler());
		//excutor must be established before start
		/*
		 * All HTTP requests are handled in tasks given to the executor.
		 */
		server.createContext("/noor", new noorHandler());
		server.setExecutor(null);
		server.start();
		
		
		

	}
	static class noorHandler implements HttpHandler{
		@Override
		public void handle(HttpExchange noor) throws IOException{
			String response= "Mia Khalifa is sexy! <html><head></head><body><h2><a href=\"http://wwww.google.com\" target=\"_blank\">Mia Xalifa </a></h2></body></html>";
			noor.sendResponseHeaders(200, response.getBytes().length);
			OutputStream outstrNoor = noor.getResponseBody();
			outstrNoor.write(response.getBytes());
			outstrNoor.close();
		}
	}
	
	
	static class wsHandler implements HttpHandler{
		 @Override
		 public void handle(HttpExchange v) throws IOException{
			 //return message for testuri 
			 String response = "hello world!";
			 v.sendResponseHeaders(200, response.getBytes().length);
			 OutputStream outstr = v.getResponseBody();
			 outstr.write(response.getBytes());
			 outstr.close();
			 outstr.flush();
			 
			 
		 }
	}
}
