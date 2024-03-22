package array;

public class ArrEx2 {
    public static void main(String[] args) {
        
    }
    static public int[] solution(int n) {
        int total = n*(n+1)/2;
        int[] answer = new int[total];
        int[][] arr = new int[n][n];
        int cur = 0;
        
        for(int i = 0; i < n; i++) {
            arr[i][0] = cur++;
        }
        for(int i = 0; i < n; i++) {
            arr[n-1][i] = cur++;
        }
        for(int i = n-1 ; i > 0; i--) {
            arr[i][i] = cur++;
        }

        return answer;
    }
}
