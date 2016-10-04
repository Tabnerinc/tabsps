package com.h2o.ps360.ui.service;

import javax.persistence.Query;

import com.h2o.ps360.dataobjects.sqldb.Patient;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;

public class PatientLoginService {
	@Transactional
	public Patient getUserInf(String emailId, String password) throws Exception {

		final String usernamequery = "SELECT u FROM Patient u WHERE u.emailId =?1 AND u.password =?2";

		Query userDbObject = JPA.em().createQuery(usernamequery);
		userDbObject.setParameter(1, emailId);
		userDbObject.setParameter(2, password);

		return (Patient) userDbObject.getSingleResult();

	}
}
