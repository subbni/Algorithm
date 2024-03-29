package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj4198_열차정렬 {
    static int[] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        memo = new int[N];
        int total = 0;
        int len = 0;
        int idx = 0;
        for(int i=0; i<N; i++) {
            if(arr[i] > memo[len]) {
                memo[len++] = arr[i];
            } else {
                idx = binarySearch(0,len,arr[i]);
                memo[idx] = arr[i];
            }
        }
        total = len;
        len = 0;
        idx = 0;
        memo = new int[N];
        for(int i=N-1; i>=0; i--) {
            if(arr[i] > memo[len]) {
                memo[len++] = arr[i];
            } else {
                idx = binarySearch(0,len,arr[i]);
                memo[idx] = arr[i];
            }
        }
        total += (len-1);
        System.out.println(total);
    }

    static int binarySearch(int left, int right, int key) {
        int mid;
        while(left<right) {
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
