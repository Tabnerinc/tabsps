package com.h2o.ps36o.utils;

import java.net.UnknownHostException;

import com.google.inject.Inject;
import com.mongodb.DB;
import com.mongodb.MongoClient;

import play.Configuration;

/*
 *   mongo.databaseps360.ip =localhost
  mongo.databaseps360.port = 27017
 */
public class MongoDbConnection {
@Inject
Configuration applicationconfiguration;
public DB mongodbConnectionWithAuthentication() throws UnknownHostException{
	String ip = applicationconfiguration.getString( "mongo.databaseps360.ip");
	int port = applicationconfiguration.getInt("mongo.databaseps360.port");
	MongoClient client = new MongoClient(ip,port);
	DB db = client.getDB("H2O");
	boolean auth = db.authenticate("venkata","mangina".toCharArray());
	System.out.println("********************************************");
	System.out.println("authorized: "+auth);
	System.out.println("********************************************");
	return db;
}
}
