package greedy;

import java.util.Scanner;

public class GreedyEx1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        int cnt = 0;
        while(N >= 1) {
            cnt++;
            if(N%K == 0) {
                N = N/K;
            } else {
                N -= 1;
            }
        }

        System.out.println(cnt);
        in.close();
    }
}
