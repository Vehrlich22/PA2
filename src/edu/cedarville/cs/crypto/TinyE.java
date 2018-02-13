package edu.cedarville.cs.crypto;

import java.util.ArrayList;

public class TinyE {
	
	public static enum Mode { ECB, CBC, CTR };
	
	public Integer[] encrypt(Integer[] plaintext, Integer[] key, Mode mode, Integer[] iv) {
            ArrayList<Integer> ciphertext = new ArrayList<Integer>();
            
            if (mode == Mode.ECB) {

            } else if (mode == Mode.CBC) {

            } else {

            }
            
            return (Integer[]) ciphertext.toArray();
	}

	public Integer[] decrypt(Integer[] ciphertext, Integer[] key, Mode mode, Integer[] iv) {
            ArrayList<Integer> plaintext = new ArrayList<Integer>();
            
            if (mode == Mode.ECB) {

            } else if (mode == Mode.CBC) {

            } else {

            }
            
            return (Integer[]) plaintext.toArray();
	}
	
}
