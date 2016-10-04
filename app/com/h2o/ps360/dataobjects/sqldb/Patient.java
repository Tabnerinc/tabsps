package com.h2o.ps360.dataobjects.sqldb;
/*
 * This is a Mariadb Entity where the entity id is setup by the same id as
 * the Object id of the record in the Mongodb, so by the id of the record we 
 * can pull the record from the Mongodb or viceversa 
 */

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	public int acId;
	public int patientId;
	public String emailId;
	public String password;
<<<<<<< Upstream, based on origin/sravani
	public boolean isActive;

=======
	public byte isActive;
	public Patient(){
		
	}
	public Patient(String emailId,String password){
		this.emailId = emailId;
		this.password = password;
	}
>>>>>>> a00d5ba local changes
	public int getAcId() {
		return acId;
	}

	public void setAcId(int acId) {
		this.acId = acId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean b) {
		this.isActive = b;
	}

}
