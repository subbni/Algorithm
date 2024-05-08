package prefixsum;

import java.util.Scanner;

public class Boj11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수의 개수
        int M = sc.nextInt(); // 합을 구해야 하는 횟수
        int arr[] = new int[N];
        int preSum[] = new int[N+1];

        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }

        preSum[0] = 0;
        for(int i=0;i<N;i++) {
            preSum[i+1] = preSum[i]+arr[i];
        }

        for(int m=0;m<M;m++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int sum = i==0? preSum[j]:preSum[j]-preSum[i-1];
            System.out.println(sum);
        }
        sc.close();
    }
}
