package edu.cedarville.cs.crypto;

import java.util.ArrayList;

public class Tools {
	
	public static Integer[] convertFromBytesToInts(byte[] bs) {
            ArrayList<Integer> ints = new ArrayList<>();
            
            for (int i = 0; i < bs.length; i+=4) {
                byte a, b, c, d;
                
                if (i < bs.length) {
                    a = (byte) (bs[i] & 0xFF);
                } else {
                    a = 0x00;
                }
                
                if (i+1 < bs.length) {
                    b = (byte) (bs[i + 1] & 0xFF);
                } else {
                    b = 0x00;
                } 
                
                if (i+2 < bs.length) {
                    c = (byte) (bs[i + 2] & 0xFF);
                } else {
                    c = 0x00;
                } 
                
                if (i+3 < bs.length) {
                    d = (byte) (bs[i + 3] & 0xFF);
                } else {
                    d = 0x00;
                }  
                
                ints.add(a | b | c | d);
            }
            
            return (Integer[]) ints.toArray();
	}
	
	public static Integer[] convertFromHexStringToInts(String s) {
            return null;
	}
	
	public static byte[] convertFromIntsToBytes(Integer[] ints) {
            return null;
	}
	
	public static String convertFromIntsToHexString(Integer[] ints) {
            String hex = "";
            
            for (Integer i : ints) {
                hex += Integer.toHexString(i);
            }
            
            return hex;
	}
	
}
