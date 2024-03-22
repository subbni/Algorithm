package greedy;

import java.util.Scanner;

public class GreedyEx5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] triangle = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                triangle[i][j] = in.nextInt();
            }
        }
        int result = solution(triangle);
        System.out.println(result);
        in.close();
    }

    static public int solution(int[][] triangle) {

        int[][] max = new int[triangle.length][triangle.length];
        
        for(int i = 0; i < triangle.length; i++) {
            max[triangle.length-1][i] = triangle[triangle.length-1][i];
        }

        for(int i = triangle.length-2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                max[i][j] = triangle[i][j] + Math.max(max[i+1][j],max[i+1][j+1]);
            }
        }

        return max[0][0];
    }

}
