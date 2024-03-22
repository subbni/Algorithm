package shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11404_플로이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
    
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 버스의 개수
    
        int[][] dist = new int[n + 1][n + 1];
        for(int i = 1 ; i <= n ; i ++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
    
        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발
            int b = Integer.parseInt(st.nextToken()); // 도착
            int c = Integer.parseInt(st.nextToken()); // 비용
    
            if(dist[a][b] > c) {
                dist[a][b] = c;
            }
        }
    
        // i:중간점   j:시작점   k:끝점
        for(int i = 1 ; i <= n ; i ++) {
            for(int j = 1 ; j <= n ; j ++) {
                if(dist[j][i] == Integer.MAX_VALUE) continue; // 시작점부터 중간점까지의 경로가 없음
                for(int k = 1 ; k <= n ; k ++) {
                    if(dist[i][k] == Integer.MAX_VALUE) continue; // 중간점부터 끝점까지의 경로가 없음
    
                    if(dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
    
        for(int i = 1 ; i <= n ; i ++) {
            for(int j = 1 ; j <= n ; j ++) {
                if(dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
