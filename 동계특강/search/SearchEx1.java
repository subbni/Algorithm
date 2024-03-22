package search;

import java.util.Scanner;

public class SearchEx1 {
    /*
     * n개의 정수를 입력받은 후, 이 정수들을 더하거나 빼서 target number를 만드는 경우의 수를 출력하라.
     * 입력 : n / n개의 수 ... / target number
     * 예시 : 1 1 1 1 1 으로 3을 만들어라
     */
    static int N;
    static int target;
    static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        target = in.nextInt();
        int result = dfs(0,0);
        System.out.println(result);
        in.close();
    }

    static public int dfs(int sum, int pos) {
        if(pos==N) {
            return sum == target? 1: 0;
        } else {
            int result = 0;
            result += dfs(sum+arr[pos],pos+1);
            result += dfs(sum-arr[pos],pos+1);
            return result;
        }
    }

}
