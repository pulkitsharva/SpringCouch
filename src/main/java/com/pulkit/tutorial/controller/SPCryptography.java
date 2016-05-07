package com.pulkit.tutorial.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class SPCryptography
{
    private static final byte[] SALT = { (byte) 0x29, (byte) 0x5F, (byte) 0x05, (byte) 0x97, (byte) 0x12, (byte) 0x01,(byte) 0x02, (byte) 0x09 };
    private static final int ITER = 5;
    private static KeySpec keySpec = null;
    private static SecretKey secretKey = null;

    private SPCryptography()
    {
    }

    public static byte[] encryptTextWithPassword(char[] password,String message)
    {       
        keySpec = new PBEKeySpec(password, SALT, ITER);
        try
        {
            secretKey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Cipher cipher = null;
        try
        {
            cipher = Cipher.getInstance(secretKey.getAlgorithm());
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        AlgorithmParameterSpec algoParamSpec = new PBEParameterSpec(SALT, ITER);
        try
        {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey,algoParamSpec);
        } 
        catch (Exception e)
        {

            e.printStackTrace();
        }
        byte[] encryptedByte = null;
        try
        {
            encryptedByte = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return encryptedByte;
    }


    public static byte[] decryptTextWithPassword(char[] password,byte[] enMex)
    {
        keySpec = new PBEKeySpec(password, SALT, ITER);
        try
        {
            secretKey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        } 
        catch(Throwable t){t.printStackTrace();}
        Cipher cipher = null;
        try
        {
            cipher = Cipher.getInstance(secretKey.getAlgorithm());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        AlgorithmParameterSpec algoParamSpec = new PBEParameterSpec(SALT, ITER);
        try
        {
            cipher.init(Cipher.DECRYPT_MODE, secretKey, algoParamSpec);
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        byte[] decryptedBytes = null;
        try
        {
            decryptedBytes = cipher.doFinal(enMex);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return decryptedBytes;
    }

    public static void main(String args[]) throws Throwable
    {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        while(true) 
        {
        String userPassword = ""; char[] userPassArray;
        String message = "";
        System.out.println("Insert Your Password");
        userPassword = tastiera.readLine();
        System.out.println("Insert The Message to Encrypt");
        message = tastiera.readLine();
        byte[] encryptedText = SPCryptography.encryptTextWithPassword(userPassword.toCharArray(),message);
        System.out.println("Original: "+message);
        System.out.println("Encrypted "+new String(encryptedText));
        System.out.println("Retype Password");
        userPassword = tastiera.readLine();
        byte[] decrypted = SPCryptography.decryptTextWithPassword(userPassword.toCharArray(),encryptedText);
        System.out.println("Decrypted "+new String(decrypted));
        }
    }

}