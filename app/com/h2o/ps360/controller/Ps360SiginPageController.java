package com.h2o.ps360.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.h2o.ps360.dataobjects.sqldb.Patient;
import com.h2o.ps360.security.utilities.CryptoHashingutility;

import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Ps360SiginPageController extends Controller{
	@Inject 
	ManagePatientAccount patientAccountManager;
	
	@Inject 
	CryptoHashingutility cryptoutility;
	@Transactional
	public Result patientLogin()
	{
		JsonNode PatientInfoFromThePatient = request().body().asJson();
		Patient patient = Json.fromJson(PatientInfoFromThePatient,Patient.class);
		String username = patient.getUsername();
		String password = patient.getPassword();
		System.out.println("----------------------------------------");
		cryptoutility.tokenStringGenerator(username, password);
		System.out.println("------------------------------");
		JsonNode jsonFormatOfValidatedpatient = patientAccountManager.findPatient(username,password);
		return ok(jsonFormatOfValidatedpatient);
		
	}
}
