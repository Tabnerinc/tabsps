package com.h2o.ps360.controller;

import javax.inject.Inject;

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
