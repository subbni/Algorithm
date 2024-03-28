package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9702_LIS {
    static int[] arr;
    static int[] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int cnt = 1;
        while(cnt++<=T) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            memo = new int[N];
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int len = 0;
            int idx = 0;
            for(int i=0; i<N; i++) {
                if(arr[i] > memo[len]) {
                    memo[len++] = arr[i];
                } else {
                    idx = binarySearch(0, len, arr[i]);
                    memo[idx] = arr[i];
                }
            }
            System.out.printf("Case #%d: %d",cnt,len);
        }
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
