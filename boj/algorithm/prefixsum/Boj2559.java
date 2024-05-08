package prefixsum;

import java.util.Scanner;

public class Boj2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 전체 날짜의 수
        int K = sc.nextInt(); // 연속적인 날짜의 수
        int arr[] = new int[N];
        int preSum[] = new int[N+1];

        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }

        preSum[0] = 0;
        for(int i=0;i<N;i++) {
            preSum[i+1] = preSum[i]+arr[i];
        }

        int max=Integer.MIN_VALUE;
        
        for(int j=N;j-K>=0;j--) {
            int sum = preSum[j]-preSum[j-K];
            if(sum>max) max = sum;
        }

        System.out.println(max);
        sc.close();
    }
}
