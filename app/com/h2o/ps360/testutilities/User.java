package com.h2o.ps360.testutilities;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
//This is a Mongo db User enity
@Entity
public class User {
	
@Id
public String id;
public String firstname;
public String lastname;
public User(){
	
}
public User(String firstname,String lastname){
	this.firstname= firstname;
	this.lastname=lastname;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
}
