/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filesharingsystem.model;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
        String key;
        public Crypto(String key_)
        {
                key = key_;
        }

        public String calculateChecksum(byte[] input) throws NoSuchAlgorithmException, IOException
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            InputStream fileInput = new ByteArrayInputStream(input);
            byte[] dataBytes = new byte[1024];

            int bytesRead = 0;

            while ((bytesRead = fileInput.read(dataBytes)) != -1) {
                messageDigest.update(dataBytes, 0, bytesRead);
            }
            byte[] digestBytes = messageDigest.digest();

            StringBuffer sb = new StringBuffer("");

            for (int i = 0; i < digestBytes.length; i++) {
                sb.append(Integer.toString((digestBytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            String ChecksumValue = sb.toString();

            fileInput.close();
            return ChecksumValue;
	}

        static byte[] fileProcessor(int cipherMode, String key, File inputFile) throws FileNotFoundException, IOException, IllegalBlockSizeException, BadPaddingException{
            try {
	    	Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
	    	Cipher cipher = Cipher.getInstance("AES");
	    	cipher.init(cipherMode, secretKey);

	    	FileInputStream inputStream = new FileInputStream(inputFile);
	    	byte[] inputBytes = new byte[(int) inputFile.length()];
	    	inputStream.read(inputBytes);

	    	byte[] outputBytes = cipher.doFinal(inputBytes);


                return outputBytes;
	    	

	    } catch (NoSuchPaddingException | NoSuchAlgorithmException 
                     | InvalidKeyException   e) {
		e.printStackTrace();
            }
            return null;
        }

        public byte[] encrypt(File inputFile) throws IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException{
            byte[] outputBytes=Crypto.fileProcessor(Cipher.ENCRYPT_MODE,key,inputFile);

            return outputBytes;

        }

        public byte[] decrypt(File inputFile) throws IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException{
            byte[] outputBytes=Crypto.fileProcessor(Cipher.DECRYPT_MODE,key,inputFile);
            return outputBytes;
        }


}
