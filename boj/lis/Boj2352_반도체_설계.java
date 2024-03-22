package lis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2352_반도체_설계 {
    public static int[] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;
        int idx = 0;
        memo = new int[n+1];
        for(int i=0; i<n; i++) {
            if(arr[i] > memo[len]) {
                len++;
                memo[len] = arr[i];
            } else {
                idx = binarySearch(0, len, arr[i]);
                memo[idx] = arr[i];
            }
        }
        System.out.println(len);
    }

    static int binarySearch(int left, int right, int key){
        int mid = 0;
        while(left < right) {
            mid = (left+right)/2;
            if(memo[mid] < key) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
