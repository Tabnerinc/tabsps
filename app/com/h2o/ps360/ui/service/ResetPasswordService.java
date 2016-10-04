package com.h2o.ps360.ui.service;

import javax.persistence.Query;

import com.h2o.ps360.dataobjects.sqldb.Patient;

import play.db.jpa.JPA;

public class ResetPasswordService {

	public Boolean isPasswordMatch(Patient patient) {
		// TODO Auto-generated method stub
		Query query=JPA.em().createQuery("select p from patient p where password=?1");
		query.setParameter(1,patient.getPassword());

		if(query.getSingleResult()==null){
			
			return null;
			
		}
		return true;
	}

}
