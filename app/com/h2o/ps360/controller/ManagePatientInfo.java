package com.h2o.ps360.controller;

<<<<<<< HEAD
import javax.inject.Inject;
=======
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.h2o.ps360.ui.service.CreatePatientInfoService;
import play.mvc.Controller;
import play.mvc.Result;

public class ManagePatientInfo extends Controller{
>>>>>>> refs/remotes/origin/venkat

import com.google.gson.Gson;
import com.h2o.ps360.dataobjects.nosqldb.PatientInfo;
import com.h2o.ps360.ui.service.CreatePatientInfoService;
import com.h2o.ps360.ui.service.GetPatientInfoService;

import play.mvc.Controller;
import play.mvc.Result;

public class ManagePatientInfo extends Controller{
	@Inject
	CreatePatientInfoService createPatientInfoService;
	
@Inject
GetPatientInfoService getPatientInfoService;
	
	/*
	 * to create patient  information
	 */
<<<<<<< HEAD
=======
	@Inject
	CreatePatientInfoService createPatientInfoService;
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
>>>>>>> refs/remotes/origin/venkat
	
	 public Result createPatientInfo(){
	  String email = request().body().asFormUrlEncoded().get("emailId")[0];
	  String password = request().body().asFormUrlEncoded().get("password")[0];
	  String firstName = request().body().asFormUrlEncoded().get("firstName")[0];
	  String secondName = request().body().asFormUrlEncoded().get("lastName")[0];
	  PatientInfo user = new PatientInfo(firstName,secondName,email,password);
	  Gson userjson = new Gson();
	  String userjsonstring = userjson.toJson(user);
	  /************The Above Part is converting the form content into JSON String which we will
	   *get from the front end****/
	  /*
	   * Save the json string in mongo db 
	   * 
	   */
	  createPatientInfoService.savePatientInfo(userjsonstring); //method
	  return ok("patient information created");
	 }
	 

	
	/*
	 * to update patient information(group) 
	 */
	public void updatePatientInfo(){
		
	}
	
	
	/*
	 * to get the patient information(group) 
	 */
	public Result getPatientInfo(){
		String email = request().body().asFormUrlEncoded().get("emailId")[0];
		
		return ok();
		  
	}
	
	
	/*
	 * to download the patient information
	 */
	public void downloadPatientInfo(){
		
	}

}
