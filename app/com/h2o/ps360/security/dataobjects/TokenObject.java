package com.h2o.ps360.security.dataobjects;

public class TokenObject {
public String acId;
public String accesstoken;
public String tokentype;
public Integer expiresin;
public String refreshtoken;
public String getAcId() {
	return acId;
}
public void setAcId(String acId) {
	this.acId = acId;
}
public String getAccesstoken() {
	return accesstoken;
}
public void setAccesstoken(String accesstoken) {
	this.accesstoken = accesstoken;
}
public String getTokentype() {
	return tokentype;
}
public void setTokentype(String tokentype) {
	this.tokentype = tokentype;
}
public Integer getExpiresin() {
	return expiresin;
}
public void setExpiresin(Integer expiresin) {
	this.expiresin = expiresin;
}
public String getRefreshtoken() {
	return refreshtoken;
}
public void setRefreshtoken(String refreshtoken) {
	this.refreshtoken = refreshtoken;
}


}
