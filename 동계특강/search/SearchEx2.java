package search;

import java.util.Scanner;

public class SearchEx2 {
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] rangeX = {0,0,-1,1};
    static int[] rangeY = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = in.next();
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && arr[i][j]==0) {
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        in.close();
    }

    static public void dfs(int n, int m) {
        visited[n][m] = true;
        for(int i = 0; i < 4; i++) {
            int dx = n + rangeX[i];
            int dy = m + rangeY[i];
            
            if(dx>=0 && dx<N && dy>=0 && dy<M && !visited[dx][dy] && arr[dx][dy]==0) {
                dfs(dx,dy);
            }
        }
    }
}
