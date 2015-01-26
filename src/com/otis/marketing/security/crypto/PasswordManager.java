package com.otis.marketing.security.crypto;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.sun.crypto.provider.SunJCE;

/**
 * used for encrypt or decrypt password
 * 
 */
public class PasswordManager {

	private Cipher encrypt_ = null;
	
	private Cipher decrypt_ = null;

	private static PasswordManager passwordManager = null;
	
	public static synchronized PasswordManager getInstance() {
		if (PasswordManager.passwordManager == null)
			passwordManager = new PasswordManager();
		return passwordManager;
	}
		
	private PasswordManager() {
		Security.addProvider(new SunJCE());
		Key key = getKey("otismarketing".getBytes());
		try {
			this.encrypt_ = Cipher.getInstance("DES");
			this.encrypt_.init(Cipher.ENCRYPT_MODE, key);
			this.decrypt_ = Cipher.getInstance("DES");
			this.decrypt_.init(Cipher.DECRYPT_MODE, key);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return;
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			return;
		}
			
	}

	public String encrypt(String aValue) throws IllegalBlockSizeException, BadPaddingException {
		return byteArr2HexStr(encrypt(aValue.getBytes()));
	}
	
	public String decrypt(String aValue) throws IllegalBlockSizeException, BadPaddingException {
		return new String(decrypt(hexStr2ByteArr(aValue)));
	}

	public String randomPassword(int aLength) {
		String passTable = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < aLength; i++) {
			int rand = (int)(Math.random() * passTable.length());
			String one = passTable.substring(rand, rand+1);
			sb.append(one);
		}
		return sb.toString();
	}
	
	private byte[] encrypt(byte[] aByte) throws IllegalBlockSizeException, BadPaddingException {
		return this.encrypt_.doFinal(aByte);
	}

	private byte[] decrypt(byte[] aByte) throws IllegalBlockSizeException, BadPaddingException {
		return this.decrypt_.doFinal(aByte);
	}

	private Key getKey(byte[] aByte) {
		byte[] arrB = new byte[8];
		for (int i = 0; i < aByte.length && i < arrB.length; i++) {
			arrB[i] = aByte[i];
		}
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
		return key;
	}

	private String byteArr2HexStr(byte[] aByte) {
		int iLen = aByte.length;
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = aByte[i];
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	private byte[] hexStr2ByteArr(String aValue) {
		byte[] arrB = aValue.getBytes();
		int iLen = arrB.length;

		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}
	
	
	public static String md5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
