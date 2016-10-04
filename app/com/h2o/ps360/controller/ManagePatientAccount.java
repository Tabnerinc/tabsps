package com.h2o.ps360.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.Query;

import com.h2o.ps360.dataobjects.sqldb.Patient;
import com.h2o.ps360.ui.service.CreatePatientAccountService;
import com.h2o.ps360.ui.service.PatientLoginService;
import com.h2o.ps360.ui.service.ResetPasswordService;

import play.db.jpa.JPA;
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
	CreatePatientAccountService patientAccServ;
	@Inject
	ResetPasswordService resetPasswordServ;
	

	public void createPatientAccount() {
	    Map<String,String[]> formfields =  request().body().asFormUrlEncoded();

		 String firstname= formfields.get("firstName")[0];
		    String lastname= formfields.get("lastName")[0];
		    String emailId= formfields.get("emailId")[0];
		    String password= formfields.get("password")[0];
		int patientid=ManagePatientInfo.patientcreatedId;
		Patient patient = new Patient(Integer.parseInt(mongouserid),patientid,emailId,password,false);

		patientAccServ.savePatient(patient);
		redirect("/signin");

	}

	/*
	 * this method activates the patient account
	 */
	public void activatePatientAccount(Patient patient) {

		patient.setIsActive(true);
		
	}

	/*
	 * patient login validation
	 */
	public Result patientLogin()
	{
		
		Map<String, String[]> formdata = request().body().asFormUrlEncoded();
		Set<String> keys= formdata.keySet();
		Iterator<String> it = keys.iterator();
		String username = formdata.get(it.next())[0];
		String password = formdata.get(it.next())[0];
		Result result = findPatient(username,password);
		return result;
		
	}
	public Result findPatient(String username,String password) {
		
		Patient users=null;
		try {
			users = patientLoginServ.getUserInf(username, password);
			System.out.println(username+password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(users==null){
			return redirect("/signin");
		}
		else
		return redirect("/home");


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
