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
	
        public static Integer[] teaEncryption(Integer[] iv, Integer[] K) {
            ArrayList<Integer> ciphertext = new ArrayList<>();
            
            Integer L = iv[0];
            Integer R = iv[1];
            Integer delta = 0x9e3779b9;
            Integer sum = 0;
            for (int i = 0; i < 32; i++) {
                sum += delta;
                L += ((R<<4)+K[0])^(R+sum)^((R>>5)+K[1]);
                R += ((L<<4)+K[2])^(L+sum)^((L>>5)+K[3]);
            }
  
            ciphertext.add(L);
            ciphertext.add(R);
            
            return (Integer[]) ciphertext.toArray();
        }
        
        public static Integer[] teaDecryption(Integer[] iv, Integer[] key) {
            ArrayList<Integer> plaintext = new ArrayList<>();
            
            
            
            return (Integer[]) plaintext.toArray();
        }
}
