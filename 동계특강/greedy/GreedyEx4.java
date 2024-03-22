package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyEx4 {
    static int[] max;
    static int[] food;
    // 개미 창고
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        max = new int[N];
        food = new int[N];
        for(int i = 0; i < N; i++) {
            food[i] = in.nextInt();
        }
        Arrays.fill(max, -1);
        max[0] = food[0];
        max[1] = food[1];

        System.out.println(getMaxFood(N-1));
        in.close();
    }

    public static int getMaxFood(int pos) {
        if(max[pos]>-1) {
            return max[pos];
        }
        return Math.max(getMaxFood(pos-1),getMaxFood(pos-2)+food[pos]);
    }
}
