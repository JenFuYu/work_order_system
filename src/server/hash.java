package server;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash {
	
	public static String change_MD5(String password) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");		//md5的hash參數
			//MessageDigest md5 = MessageDigest.getInstance("SHA1");	//sha1的hash參數
			md5.update(password.getBytes());
			return new BigInteger(1,md5.digest()).toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
