package edu.cedarville.cs.crypto;

import java.util.ArrayList;

public class Tools {
	
	public static Integer[] convertFromBytesToInts(byte[] bs) {
            ArrayList<Integer> ints = new ArrayList<>();
            
            for (int i = 0; i < bs.length; i += 4) {
                byte a, b, c, d;
                
                if (i < bs.length) {
                    a = (byte) (bs[  i  ] & 0xFF);
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
            ArrayList<Integer> ints = new ArrayList<>();
            
            for (int i = 0; i < s.length(); i += 4) {
                String hex = "";
                if (i + 4 < s.length()) {
                    hex = s.substring(i, i + 4);
                } else if (i + 3 < s.length()) {
                    hex = s.substring(i, i + 3) + "0000";
                } else if (i + 2 < s.length()) {
                    hex = s.substring(i, i + 2) + "00000000";
                } else if (i + 1 < s.length()) {
                    hex = s.substring(i, i + 1) + "000000000000";
                }
                ints.add((int) Long.parseLong(hex, 16));
            }
            
            return (Integer[]) ints.toArray();
	}
	
	public static byte[] convertFromIntsToBytes(Integer[] ints) {
            byte[] bytes = new byte[ints.length * 4];
            
            for (int i = 0; i < ints.length * 4; i += 4) {
                bytes[  i  ] = (byte) ((ints[i] >> 24) & 0x000000FF);
                bytes[i + 1] = (byte) ((ints[i] >> 16) & 0x000000FF);
                bytes[i + 2] = (byte) ((ints[i] >>  8) & 0x000000FF);
                bytes[i + 3] = (byte) ( ints[i]        & 0x000000FF);
            }
            
            return bytes;
	}
	
	public static String convertFromIntsToHexString(Integer[] ints) {
            String hex = "";
            
            for (Integer i : ints) {
                hex += Integer.toHexString(i);
            }
            
            return hex;
	}
}
