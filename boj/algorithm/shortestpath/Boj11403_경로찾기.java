package shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11403_경로찾기 {
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(matrix[j][i]==0) continue;
                for(int k=0; k<N; k++) {
                    if(matrix[i][k]==1) {
                        matrix[j][k]=1;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(matrix[i][j]==1?"1":"0").append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
