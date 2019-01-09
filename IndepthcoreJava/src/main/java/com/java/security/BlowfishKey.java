package com.java.security;

import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class BlowfishKey {

	public static void main(String[] args) throws Exception{
		String name = "gopi jithendra ganesh kumar";
	    Provider provide = new com.sun.crypto.provider.SunJCE();
	    Security.addProvider(provide);
	    KeyGenerator kgen = KeyGenerator.getInstance("Blowfish");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        kgen.init(random);
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        // Encrypt ...
        byte[] encrypted = 
            cipher.doFinal(name.getBytes());
        System.out.println(Arrays.toString(encrypted));
        for(byte b: encrypted){
        	System.out.print(b);
        }
	}
}
