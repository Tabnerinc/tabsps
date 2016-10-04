package com.h2o.ps36o.utils;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDbConnection {
	
	public DB mongodbconnectionwith() throws UnknownHostException{
		String ip = "127.0.0.1";
		int port = 27017;
		MongoClient client = new MongoClient(ip,port);
		DB db = client.getDB("h2o");
		System.out.println("********************************************");
		return db;
	}

}
