package lis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2491_수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 1;
        int iLen = 1, dLen = 1;
        for(int i = 1; i < n; i++) {
            iLen = arr[i] >= arr[i-1] ? iLen+1 : 1;
            dLen = arr[i] <= arr[i-1] ? dLen+1 : 1;

            maxLen = Math.max(Math.max(iLen,dLen),maxLen);
        }

        System.out.println(maxLen);
    }
}
