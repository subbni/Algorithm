package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj4198_열차정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] inDp = new int[N];
        int[] deDp = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++) {
            inDp[i] = 1;
            deDp[i] = 1;
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    // LIS
                    inDp[i] = Math.max(inDp[i], inDp[j]+1);
                } else {
                    // LDS
                    deDp[i] = Math.max(deDp[i], deDp[j]+1);
                }
            }
        }

        int inMax = 0;
        int idx = 0;
        int deMax = 0;
        for(int i=0; i<N; i++) {
            if(inMax < inDp[i]) {
                inMax = inDp[i];
                idx = i;
            }
        }
        for(int i=0; i<idx; i++) {
            if(deMax < deDp[i]) deMax = deDp[i];
        }

        System.out.println(N==0? 0: inMax+deMax-1);
    }
}
