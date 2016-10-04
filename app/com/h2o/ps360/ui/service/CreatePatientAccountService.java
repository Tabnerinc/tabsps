package com.h2o.ps360.ui.service;

import com.h2o.ps360.dataobjects.sqldb.Patient;

import play.db.jpa.JPA;

public class CreatePatientAccountService {
	
	
	public void savePatient(Patient patient){ 
	 JPA.em().persist(patient);
	}
	


}
