package backtracking;

import java.util.Scanner;

public class Boj14888 {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = in.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            operators[i] = in.nextInt();
        }

        for(int i = 0; i < N-1 ; i++) { // 모든 경우의 수

        }

        in.close();
    }

    public static int dfs(int[] operators, int[] numbers, int pos, int sum) {
        if(pos>=numbers.length-2) return sum;
        int result = sum;
        for(int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                int nextSum = pos==0? operate(numbers[0], result, i)
                dfs(operators, numbers, pos+1, pos==0?:);
            }
        }
    }

    public static int operate(int operand1, int operand2, int operator) {
        int result;
        switch (operator) {
            case 0:
                result = operand1+operand2;
                break;
            case 1:
                result = operand1-operand2;
                break;
            case 2:
                result = operand1*operand2;
                break;
            case 3:
                result = operand1/operand2;
                break;
            default:
                throw new IllegalArgumentException("operator 범위 0 ~ 3");
        }
        return result;
    }
}
