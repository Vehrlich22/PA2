package edu.cedarville.cs.crypto;

import java.util.ArrayList;

public class TinyE {
	
	public static enum Mode { ECB, CBC, CTR };
	
	public Integer[] encrypt(Integer[] plaintext, Integer[] key, Mode mode, Integer[] iv) {
            ArrayList<Integer> ciphertext = new ArrayList<Integer>();
            
            if (mode == Mode.ECB) {
//                C0 = E(P0, K)
//                C1 = E(P1, K)


            } else if (mode == Mode.CBC) {
//                C0 = E(IV  P0, K)
//                C1 = E(C0  P1, K)
                

            } else {
//                C0 = P0  E(IV, K)
//                C1 = P1  E(IV+1, K)


            }
            
            return (Integer[]) ciphertext.toArray();
	}

	public Integer[] decrypt(Integer[] ciphertext, Integer[] key, Mode mode, Integer[] iv) {
            ArrayList<Integer> plaintext = new ArrayList<Integer>();
            
            if (mode == Mode.ECB) {
//                P0 = D(C0, K)
//                P1 = D(C1, K)


            } else if (mode == Mode.CBC) {
//                P0 = IV  D(C0, K)
//                P1 = C0  D(C1, K)


            } else {
//                P0 = C0  E(IV, K)
//                P1 = C1  E(IV+1, K)


            }
            
            return (Integer[]) plaintext.toArray();
	}
	
        public static Integer[] teaEncryption(Integer[] iv, Integer[] key) {
            ArrayList<Integer> ciphertext = new ArrayList<>();
            
            
            
            return (Integer[]) ciphertext.toArray();
        }
        
        public static Integer[] teaDecryption(Integer[] iv, Integer[] key) {
            ArrayList<Integer> plaintext = new ArrayList<>();
            
            
            
            return (Integer[]) plaintext.toArray();
        }
}
