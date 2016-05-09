package ro.go.mariusiliescu.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHAEncryption {
	static String encript(String password) {
		String md5 = null;
		try {
			MessageDigest md = MessageDigest.getInstance("Sha512");
	
			try {
				md.update(password.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			byte[] digest = md.digest();
	
			md5 = new BigInteger(1,digest).toString(16);
	
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
}
