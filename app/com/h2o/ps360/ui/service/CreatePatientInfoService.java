package com.h2o.ps360.ui.service;

import com.h2o.ps36o.utils.MongoDbConnection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/*
 * CreatePatientInfoService is used for creating the Information of the patient
 * PatientInfo has the following details
 * a.patientId   b.firstName c.lastName so create
 */
public class CreatePatientInfoService {
Integer patientId = 2000;
MongoDbConnection mongo = new MongoDbConnection();
	public int createPatientSignupInfo(String inputStringFromPatient){
		int patientIdAllocated = patientId;
		DBObject patientInfo = (DBObject) JSON.parse(inputStringFromPatient);
		patientInfo.put("patientId",patientId);
		patientId++;
		return patientIdAllocated;
	}
	/*
	 * The Method savePatientInfo will save the patientInfo Object in PatientInfo in Mongodb
	 * and will return a boolean return type if the object is saved or not saved so we can 
	 * proceed with saving user details in Maria
	 * 
	 * As user details without profile is not useful we have to stop null values insertions in 
	 * Mongodb PatientInfo
	 */
	public boolean savePatientInfo(DBObject patientInfo){
		boolean savedFlag = true;
		try{
			mongo.mongodbConnectionWithAuthentication().getCollection("patientInfo").save(patientInfo);
		}catch(Exception e)
		{
			savedFlag = false;
			e.printStackTrace();
		}
		return savedFlag;
	}
}
