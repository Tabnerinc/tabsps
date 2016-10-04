package com.h2o.ps360.dataobjects.nosqldb;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class PatientInfo {
		@Id
		public int id;
		public String emailId;
		public String password;
	
	
}
