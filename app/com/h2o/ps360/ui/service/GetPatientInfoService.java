package com.h2o.ps360.ui.service;

import java.net.UnknownHostException;

import com.google.inject.Inject;
import com.h2o.ps360.testutilities.User;
import com.h2o.ps360.utils.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class GetPatientInfoService {
	@Inject
	MongoDbConnection mongodb;
	
	public DBObject getPatientInfoList(String username1){
		DBCollection tableDetails;
		DBObject userobjectfrommongo = null;
		try {
			tableDetails = mongodb.mongodbConnectionWithAuthentication().getCollection("patientInfo");
			 BasicDBObject queryDetails = new BasicDBObject();
			 queryDetails.put("username",username1);
		userobjectfrommongo= tableDetails.findOne(queryDetails);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userobjectfrommongo;
	}
	
}
