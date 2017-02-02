package com.supinfo.courses.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
	public static String hashMD5(String s) throws Exception{
		byte[] bytes;
		try {
			bytes = s.getBytes("UTF-8");	
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("MD5");
				byte[] hashed = md.digest(bytes);
				return new String(hashed, "UTF-8");
			} catch (NoSuchAlgorithmException e) {
				throw new Exception("Error while hashing", e);
			}
		} catch (UnsupportedEncodingException e) {
			throw new Exception("Error while reading UTF8", e);
		}
	}
}
