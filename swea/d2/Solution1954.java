package swea.d2;

import java.io.*;

// 달팽이 숫자
public class Solution1954 {
    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
            cnt = 1;
            dfs(0,0,0);
            sb.append("#"+t);
            for(int i=0; i<N; i++) {
                sb.append('\n');
                for(int j=0; j<N; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int row, int col, int dir) {
        arr[row][col] = cnt;
        visited[row][col] = true;   

        if(cnt == N*N) return;
        cnt++;

        int nx = row + dx[dir];
        int ny = col + dy[dir];

        if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) {
            dir = (dir+1)%4;
            nx = row + dx[dir];
            ny = col + dy[dir];
        }
      dfs(nx,ny,dir);
     }
}