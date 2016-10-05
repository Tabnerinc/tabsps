package com.h2o.ps360.controller;
import com.google.inject.Inject;
import com.h2o.ps360.ui.service.CreatePatientInfoService;


public class ManagePatientInfo{
@Inject
CreatePatientInfoService createPatientInfoService;
	public int createPatientInfo(String inputStringFromPatientForm){
		int patientcreatedId = createPatientInfoService.createPatientSignupInfo(inputStringFromPatientForm);
		return patientcreatedId;

	}
	
	
	/*
	 * to update patient information(group) 
	 */
	public void updatePatientInfo(){
		
	}
	
	
	/*
	 * to get the patient information(group) 
	 */
	public void getPatientInfo(){
		
	}
	
	
	/*
	 * to download the patient information
	 */
	public void downloadPatientInfo(){
		
	}

}
