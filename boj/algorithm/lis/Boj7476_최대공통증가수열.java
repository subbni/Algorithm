package lis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj7476_최대공통증가수열 {
    static int[] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 배열 초기화
        int N = Integer.parseInt(br.readLine());
        int arr1[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());   
        }
        int M = Integer.parseInt(br.readLine());
        int arr2[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());   
        }

        // 각 수열의 LIS를 각각 구하고 저장
        LinkedList<Integer> LIS1 = getLIS(arr1);
        LinkedList<Integer> LIS2 = getLIS(arr2);

        // 두 LIS 중 겹치는 부분을 저장
        LinkedList<Integer> answer = new LinkedList<>();
        while(!LIS1.isEmpty() && !LIS2.isEmpty()) {
            if (LIS1.peek() == LIS2.peek()) {
                answer.add(LIS1.peek());
                LIS1.remove();
                LIS2.remove();
            } else if (LIS1.peek() > LIS2.peek()) {
                LIS2.remove();
            } else {
                LIS1.remove();
            }
        }

        System.out.println(answer.size());
        for(int element : answer) {
            System.out.print(element+" ");
        }
    }

    static int binarySearch(int left, int right, int key) {
        int mid;
        while(left < right) {
            mid = (left+right)/2;
            if (memo[mid] < key) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    static LinkedList<Integer> getLIS(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = arr.length;
        int len = 0, idx = 0;
        memo = new int[n]; 
        memo[0] = arr[0];
        list.add(arr[0]);
        for(int i=1; i<n; i++) {
            if (arr[i] > memo[len]) {
                memo[++len] = arr[i];
                list.add(arr[i]);
            } else {
                idx = binarySearch(0, len, arr[i]);
                if(idx>0) {
                    list.set(list.indexOf(memo[idx]),arr[i]);
                }    
            }
        }
        return list;
    }
}
