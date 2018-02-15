package edu.cedarville.cs.crypto;

public class Tools {
	
	public static Integer[] convertFromBytesToInts(byte[] bs) {
            Integer[] ints = new Integer[bs.length / 4];
            
            for (int i = 0; i < bs.length; i += 4) {
                Integer a, b, c, d;
                
                // Convert the first byte
                if (i < bs.length) {
                    a = (Integer) ((bs[  i  ] & 0xFF) << 24);
                } else {
                    a = 0x00;
                }
                                
                // Convert the second byte
                if (i+1 < bs.length) {
                    b = (Integer) ((bs[i + 1] & 0xFF) << 16);
                } else {
                    b = 0x00;
                } 
                                
                // Convert the third byte
                if (i+2 < bs.length) {
                    c = (Integer) ((bs[i + 2] & 0xFF) << 8);
                } else {
                    c = 0x00;
                } 
                                
                // Convert the fourth byte
                if (i+3 < bs.length) {
                    d = (Integer) (bs[i + 3] & 0xFF);
                } else {
                    d = 0x00;
                }  
                
                // Combine the 4 bytes to a 32bit Integer
                ints[i / 4] = (a | b | c | d);
            }
            
            return ints;
	}
	
	public static Integer[] convertFromHexStringToInts(String s) {
            Integer[] ints = new Integer[s.length() / 8];
            
            for (int i = 0; i < s.length(); i += 8) {
                String hex = "";
                if (i + 8 <= s.length()) {
                    // Without padding
                    hex = s.substring(i, i + 8);
                } else {
                    // With padding
                    hex = s.substring(i);
                    hex = String.format("%-8s", hex).replace(' ', '0');
                }
                ints[i / 8] = (int) Long.parseLong(hex, 16);
            }
            
            return ints;
	}
	
	public static byte[] convertFromIntsToBytes(Integer[] ints) {
            byte[] bytes = new byte[ints.length * 4];
            
            for (int i = 0; i < ints.length * 4; i += 4) {
                // Take a Intger and separate it into 4 bytes
                bytes[  i  ] = (byte) (ints[i / 4] >> 24 & 0x000000FF);
                bytes[i + 1] = (byte) (ints[i / 4] >> 16 & 0x000000FF);
                bytes[i + 2] = (byte) (ints[i / 4] >>  8 & 0x000000FF);
                bytes[i + 3] = (byte) (ints[i / 4] & 0x000000FF);
            }
            
            return bytes;
	}
	
	public static String convertFromIntsToHexString(Integer[] ints) {
            String hex = "";
            
            for (Integer i : ints) {
                // Convert an Integer to a hex string
                hex += Integer.toHexString(i);
            }
            
            return hex;
	}
}
