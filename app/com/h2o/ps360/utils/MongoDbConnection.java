package com.h2o.ps360.utils;

import java.net.UnknownHostException;

import com.google.inject.Inject;
import com.mongodb.DB;
import com.mongodb.MongoClient;

import play.Configuration;

public class MongoDbConnection {
	
	@Inject
	Configuration applicationconfiguration;
	public DB mongodbConnectionWithAuthentication() throws UnknownHostException{
		String ip = applicationconfiguration.getString("mongo.first.ip");
		int port = applicationconfiguration.getInt("mongo.first.port");
		MongoClient client = new MongoClient(ip,port);
		DB db = client.getDB("H2O");
		boolean auth = db.authenticate("venkata","mangina".toCharArray());
		System.out.println("****************************"+auth+ip+" "+port);
		return db;
	}

}
