package com.h2o.ps360.controller;

import javax.inject.Inject;

import com.google.gson.Gson;
import com.h2o.ps360.dataobjects.nosqldb.PatientInfo;
import com.h2o.ps360.ui.service.CreatePatientInfoService;
import com.h2o.ps360.ui.service.GetPatientInfoService;
import com.mongodb.DBObject;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class ManagePatientInfo extends Controller {
	@Inject
	CreatePatientInfoService createPatientInfoService;

	@Inject
	GetPatientInfoService getPatientInfoService;

	/*
	 * to create patient information
	 */

	public Result createPatientInfo(){
		String email = request().body().asFormUrlEncoded().get("emailId")[0];
		String password = request().body().asFormUrlEncoded().get("password")[0];
		String firstName = request().body().asFormUrlEncoded().get("firstName")[0];
		String secondName = request().body().asFormUrlEncoded().get("lastName")[0];
		com.h2o.ps360.testutilities.User user = new com.h2o.ps360.testutilities.User(firstName,secondName,email,password);
		Gson userjson = new Gson();
		String inputStringFromPatientForm = userjson.toJson(user);
		/*********************converting the paramters into string***********************************/
		int patientcreatedId = createPatientInfoService.createPatientSignupInfo(inputStringFromPatientForm);
		if(patientcreatedId==0){
			System.out.println("patient created : false with patientid"+patientcreatedId);
			return ok("not created");
		}
		else
		{
			System.out.println("patient created : true with patientId"+patientcreatedId);
			return ok("created");
		}
	}

	
	/*
	 * to update patient information(group)
	 */
	public void updatePatientInfo() {
		String username = request().body().asFormUrlEncoded().get("username")[0];
		
	}

	/*
	 * to get the patient information(group)
	 */
	public Result getPatientInfo() {
		String username = request().body().asFormUrlEncoded().get("username")[0];
		DBObject user = getPatientInfoService.getPatientInfoList(username);	
		return ok(Json.toJson(user));

	}

	/*
	 * to download the patient information
	 */
	public void downloadPatientInfo() {

	}

}
