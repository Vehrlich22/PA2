package edu.cedarville.cs.crypto;

import java.util.ArrayList;

public class TinyE {
	
	public static enum Mode { ECB, CBC, CTR };
	
	public Integer[] encrypt(Integer[] p, Integer[] k, Mode m, Integer[] iv) {
            Integer[] ciphertext = new Integer[p.length];
            
            if (m == Mode.ECB) {
//                C0 = E(P0, K)
//                C1 = E(P1, K)
                Integer[] ciphertextHolder;
                for (int i = 0; i < p.length; i += 2) {
                    ciphertextHolder = teaEncryption(p[i], p[i + 1], k);
                    ciphertext[  i  ] = ciphertextHolder[0];
                    ciphertext[i + 1] = ciphertextHolder[1];
                }

            } else if (m == Mode.CBC) {
//                C0 = E(IV  P0, K)
//                C1 = E(C0  P1, K)
                

            } else {
//                C0 = P0  E(IV, K)
//                C1 = P1  E(IV+1, K)


            }
            
            return ciphertext;
	}

	public Integer[] decrypt(Integer[] c, Integer[] k, Mode m, Integer[] iv) {
            Integer[] plaintext = new Integer[c.length];
            
            if (m == Mode.ECB) {
//                P0 = D(C0, K)
//                P1 = D(C1, K)
                Integer[] plaintextHolder;
                for (int i = 0; i < c.length; i+=2) {
                    plaintextHolder = teaDecryption(c[i], c[i+1], k);
                    plaintext[  i  ] = plaintextHolder[0];
                    plaintext[i + 1] = plaintextHolder[1];
                }

            } else if (m == Mode.CBC) {
//                P0 = IV  D(C0, K)
//                P1 = C0  D(C1, K)


            } else {
//                P0 = C0  E(IV, K)
//                P1 = C1  E(IV+1, K)


            }
            
            return plaintext;
	}
	
        public static Integer[] teaEncryption(Integer L, Integer R, Integer[] K) {
            Integer[] ciphertext = new Integer[2];
            
            Integer delta = 0x9e3779b9;
            Integer sum = 0;
            for (int i = 0; i < 32; i++) {
                sum += delta;
                L += ((R << 4) + K[0]) ^ (R + sum) ^ ((R >> 5) + K[1]);
                R += ((L << 4) + K[2]) ^ (L + sum) ^ ((L >> 5) + K[3]);
            }
  
            ciphertext[0] = L;
            ciphertext[1] = R;
            
            return ciphertext;
        }
        
        public static Integer[] teaDecryption(Integer L, Integer R, Integer[] K) {
            Integer[] plaintext = new Integer[2];
            
            Integer delta = 0x9E3779B9;
            Integer sum = delta << 5;
            
            for (int i = 0; i < 32; i++) {
                R -= ((L << 4) + K[2]) ^ (L + sum) ^ ((L >> 5) + K[3]);
                L -= ((R << 4) + K[0]) ^ (R + sum) ^ ((R >> 5) + K[1]);
                sum -= delta;
            }
            
            plaintext[0] = L;
            plaintext[1] = R;
            
            return plaintext;
        }
}
