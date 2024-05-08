package dfsbfs;

import java.util.Scanner;

public class Boj2468 {
    static int matrix[][];
    static boolean visited[][];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        matrix = new int[N][N];
        visited = new boolean[N][N];
        int maxHeight = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
                if(matrix[i][j]>maxHeight) {
                    maxHeight = matrix[i][j];
                } 
            }
        }

        int maxComponent = 0;
        for(int h = 0; h <= maxHeight; h++) {     // 각 높이마다 계산
            int numOfComponent = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(matrix[i][j]>h && !visited[i][j]) {
                        dfs(h,i,j);
                        numOfComponent++;
                    }
                }
            }
            if(maxComponent<numOfComponent) {
                maxComponent = numOfComponent;
            }
            visited = new boolean[N][N];
        }

        System.out.println(maxComponent);
        in.close();
    }

    static public void dfs(int height, int i, int j) {
        visited[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int x = i+dx[k];
            int y = j+dy[k];
            if(x>=0 && x<matrix.length && y>=0 && y<matrix.length) {
                if(matrix[x][y]>height && !visited[x][y]) {
                    dfs(height,x,y);
                }
            }
        }
    } 
}
