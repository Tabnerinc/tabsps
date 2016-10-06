package com.h2o.ps360.dataobjects.ui.service.dataobjects;

import com.h2o.ps360.security.dataobjects.TokenObject;
import com.h2o.ps360.security.dataobjects.UserAuthorizationRole;

public class PatientValidatedDataObject {
public boolean validated;
public UserAuthorizationRole authrole;
public TokenObject token;
public boolean isValidated() {
	return validated;
}
public void setValidated(boolean validated) {
	this.validated = validated;
}

public TokenObject getToken() {
	return token;
}
public void setToken(TokenObject token) {
	this.token = token;
}


}
