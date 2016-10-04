package com.h2o.ps360.ui.service;

import java.net.UnknownHostException;

import javax.inject.Inject;

import com.h2o.ps360.utils.MongoDbConnection;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class CreatePatientInfoService {

	@Inject
	MongoDbConnection mongodb;

	public void savePatientInfo(String jsonstring) {
		DB db = null;
		DBObject patientInfo = (DBObject) JSON.parse(jsonstring);
		try {
			db = mongodb.mongodbconnectionwith();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.getCollection("PatientInfo").save(patientInfo);
	}

}
