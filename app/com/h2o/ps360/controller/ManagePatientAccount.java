package com.h2o.ps360.controller;

import javax.inject.Inject;
import com.fasterxml.jackson.databind.JsonNode;
import com.h2o.ps360.dataobjects.sqldb.Patient;
import com.h2o.ps360.dataobjects.ui.service.dataobjects.PatientValidatedDataObject;
import com.h2o.ps360.ui.service.CreatePatientAccountService;
import com.h2o.ps360.ui.service.PatientLoginService;
import com.h2o.ps360.ui.service.ResetPasswordService;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


/*
 * MariaDB
 */
public class ManagePatientAccount extends Controller {

	/*
	 * it Creates patient Account method
	 */
	@Inject
	PatientLoginService patientLoginServ;
	@Inject
	CreatePatientAccountService patientaccountservice;
	@Inject
	ResetPasswordService resetPasswordServ;
	
/*
 * Create Patient will save the patient "Account" details in the MariaDb 
 */
	public boolean createPatientAccount(Patient patient) {
		boolean saved=patientaccountservice.savePatient(patient);
		return saved;

	}

	/*
	 * this method activates the patient account
	 */
	public void activatePatientAccount(Patient patient) {

		patient.setIsActive(true);
		
	}

	/*
	 * patient login validation Is done by 
	 */
	
	public JsonNode findPatient(String username,String password) {
		
		Patient users=null;
	    PatientValidatedDataObject validatedpatient = new PatientValidatedDataObject();
		try {
			users = patientLoginServ.getUserInf(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(users==null){
		//	validatedpatient.setAuthrole("anonymous");
			validatedpatient.setToken(null);
			validatedpatient.setValidated(false);
		}
		else
		{
		//	validatedpatient.setAuthrole("user");
			/*
			 * we cannot set cookie for serialization , so we can send cookie attributes as 
			 * a another json
			 */
		//	validatedpatient.setToken(username.substring(2,4)+password.substring(2,4));
			validatedpatient.setValidated(true);
		}
		JsonNode JsonFormatOfValidatedPatientInfo = Json.toJson(validatedpatient);
		return JsonFormatOfValidatedPatientInfo;
	}

	/*
	 * reset patient login password
	 */
	public Result resetPassword(Patient patient) {
		if(resetPasswordServ.isPasswordMatch(patient))
		{
	           return redirect("/resetPassword");

		}
		return null;
		
	}

}
