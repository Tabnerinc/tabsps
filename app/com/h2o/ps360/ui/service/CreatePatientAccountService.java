package com.h2o.ps360.ui.service;

import com.h2o.ps360.dataobjects.sqldb.Patient;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;


public class CreatePatientAccountService {
	
	@Transactional
	public boolean savePatient(Patient patient) {
		boolean saved = true;
		try{
		JPA.em().persist(patient);
		}catch(Exception e){
			saved = false;
			e.printStackTrace();
		}
		return saved;
	}
}
