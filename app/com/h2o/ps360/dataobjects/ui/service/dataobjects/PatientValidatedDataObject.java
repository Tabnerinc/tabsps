package com.h2o.ps360.dataobjects.ui.service.dataobjects;

public class PatientValidatedDataObject {
public boolean validated;
public String token;
public String authrole;
public boolean isValidated() {
	return validated;
}
public void setValidated(boolean validated) {
	this.validated = validated;
}

public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public String getAuthrole() {
	return authrole;
}
public void setAuthrole(String authrole) {
	this.authrole = authrole;
}

}
