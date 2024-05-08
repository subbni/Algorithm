package swea.d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1945 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for(int t=1; t<=T; t++) {
            int number = Integer.parseInt(br.readLine());
            int[] primes = {2,3,5,7,11};
            int[] exponents = new int[5];

            int cur = number;
            while(cur>1) {
                for(int i=0; i<primes.length; i++) {
                    if(cur%primes[i] == 0) {
                        exponents[i]++;
                        cur = cur/primes[i];
                        break;
                    }
                }
            }

            bw.write("#"+t+" ");
            for(int exponent: exponents) {
                bw.write(exponent+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
