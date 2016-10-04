package com.h2o.ps360.controller;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.h2o.ps360.dataobjects.sqldb.Patient;

import play.mvc.Controller;
import play.mvc.Result;

public class Ps360SignupPageController extends Controller{
@Inject 
ManagePatientInfo patientinfo;
@Inject 
ManagePatientAccount patientaccount; 
	public Result SigninPage(){
		String email = request().body().asFormUrlEncoded().get("emailId")[0];
		String password = request().body().asFormUrlEncoded().get("password")[0];
		String firstName = request().body().asFormUrlEncoded().get("firstName")[0];
		String secondName = request().body().asFormUrlEncoded().get("lastName")[0];
		com.h2o.ps360.testutilities.User user = new com.h2o.ps360.testutilities.User(firstName,secondName);
		Patient patient = new Patient(email,password);
		Gson userjson = new Gson();
		String inputStringFromPatientForm = userjson.toJson(user);
		
		/*********************converting the paramters into string***********************************/
		int patientcreatedId = patientinfo.createPatientInfo(inputStringFromPatientForm);
		
		if(patientcreatedId==0){
			
			System.out.println("patient created : false with patientid"+patientcreatedId);
			return ok("not created");
		}
		else
		{
			patient.setAcId(patientcreatedId);
			patient.setPatientId(patientcreatedId);
			patientaccount.createPatientAccount(patient);
			System.out.println("patient created : true with patientId"+patientcreatedId);
			return ok("created");
		}
	}
}
