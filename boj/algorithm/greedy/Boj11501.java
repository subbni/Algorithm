package greedy;

import java.util.Scanner;

public class Boj11501 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        StringBuilder sb = new StringBuilder();

        while(T-->0) {
            int N = in.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
            }

            long max = 0;
            long profit = 0;
            for(int i = N-1; i >= 0; i--) {
                if (arr[i] < max) {
                    profit += max-arr[i];
                } else { // max 갱신
                    max = arr[i];
                }
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb);
        in.close();
    }
}
