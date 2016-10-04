package com.h2o.ps360.dataobjects.nosqldb;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class PatientInfo {
	
		@Id
		public String id;
		public String emailId;
		public String password;
		public String firstName;
		public String lastName;
		
		public PatientInfo(String firstName2, String secondName, String email, String password2) {
			// TODO Auto-generated constructor stub
		}
}
