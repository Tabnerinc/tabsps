package com.h2o.ps360.controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.h2o.ps360.dataobjects.sqldb.Patient;
import com.h2o.ps360.dataobjects.ui.service.dataobjects.SignupResponseObject;

import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Ps360SignupPageController extends Controller{
@Inject 
ManagePatientInfo patientinfo;
@Inject 
ManagePatientAccount patientaccount; 
@Transactional
	public Result SignupPage(){
System.out.println("*****************************************************");
				SignupResponseObject signupresponseobject = new SignupResponseObject();
		JsonNode signuprequest= request().body().asJson();
		/*********************converting the paramters into string***********************************/
		int patientcreatedId = patientinfo.createPatientInfo(Json.stringify(signuprequest));
		// patient is a mariadb entity
		Patient patient = new Patient();
		if(patientcreatedId==0){
			signupresponseobject.setDefaultdomaincookie("h2odomaincookie");
			signupresponseobject.setHttpresponse(400);
			signupresponseobject.setResponsedescription("bad request,patient info not saved");
			signupresponseobject.setPatientid(null);
			signuprequest = Json.toJson(signupresponseobject);
			System.out.println("patient created : false with patientid"+patientcreatedId);
			return ok(signuprequest);
		}
		else
		{
			Gson gson = new Gson();
			patient = gson.fromJson(Json.stringify(signuprequest),Patient.class);
			patient.setAcId(patientcreatedId);
			patient.setPatientId(patientcreatedId);
			patient.setIsActive(false);
			boolean patientaccountcreated = patientaccount.createPatientAccount(patient);;
			if(patientaccountcreated){
			signupresponseobject.setDefaultdomaincookie("h2odomaincookie");
			signupresponseobject.setHttpresponse(200);
			signupresponseobject.setPatientid(patientcreatedId);
			signupresponseobject.setResponsedescription("patient successfully registered");
			signuprequest = Json.toJson(signupresponseobject);
			return ok(signuprequest);
			}
			else{
				signupresponseobject.setDefaultdomaincookie("h2odomaincookie");
				signupresponseobject.setHttpresponse(400);
				signupresponseobject.setPatientid(null);
				signupresponseobject.setResponsedescription("patient account details not saved");
				signuprequest = Json.toJson(signupresponseobject);
				return ok(signuprequest);
			}
		}
	}
}
