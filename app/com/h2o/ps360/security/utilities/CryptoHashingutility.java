package com.h2o.ps360.security.utilities;

import org.mindrot.jbcrypt.BCrypt;

import com.google.inject.Inject;

import play.Configuration;

public class CryptoHashingutility {

	@Inject
	Configuration appconfig;

 public String hashingservice(String stringToBeHashed){ 
String hash = appconfig.getString("play.crypto.secret");
 String hashedstring =  stringToBeHashed + hash;
 return hashedstring;
 }
//	return hashedstring;
//	}
//	
//	public String rehashingservice(String stringtobeRehashed){
//		int cryptostringlength = stringtobeRehashed.length();
//		int keylength = this.hashingsecretkey.length();
//		int lengthofrehashstring = cryptostringlength-keylength;
//		String rehashedstring = stringtobeRehashed.substring(0,lengthofrehashstring-1);
//		return rehashedstring;
//	}
	public void tokenStringGenerator(String username,String password){
		
        String usernamehashed = hashingservice(username);
        String passwordhashed = hashingservice(password);
        String encryptedusername = BCrypt.hashpw(username,BCrypt.gensalt());
        String encryptedpassword =BCrypt.hashpw(password, BCrypt.gensalt());

        if(BCrypt.checkpw(username,encryptedusername)&&BCrypt.checkpw(password,encryptedpassword)){
		System.out.println(hashingservice(username));
    }
	}
	

}
