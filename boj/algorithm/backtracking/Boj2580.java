package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2580 {
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        matrix = new int[9][9];
        int last = 0;
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<9; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j]==0) last++;
            }
        }
        sudoku(last);
        System.out.println(sb);
    }

    public static boolean sudoku(int last) {
        if(last == 0) { // 더 이상 빈자리가 없는 경우 스도쿠 출력
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(matrix[i][j]).append(' ');
                }
                sb.append('\n');
            }
            return true;
        }

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(matrix[i][j]==0) { // 빈 자리 [i][j] 찾기
                    int bit1 = checkRowAndCol(i, j); 
                    int bit2 = checkSquare(i,j);
                    int bit = bit1 | bit2;

                    for(int pos=1; pos<=9; pos++) {
                        if(((bit >> pos) & 1) == 0) { // [i][j]에 넣을 수 있는 수 = pos 찾기
                            matrix[i][j] = pos; 
                            if(sudoku(last-1)) { // [i][j] = pos 넣고, 다음 빈 자리로
                                return true; 
                            }
                            matrix[i][j] = 0; // 만일 도중에 실패한다면, 다시 [i][j] = 0 처리
                        }
                    }
                    if(matrix[i][j]==0) return false; // [i][j]에 넣을 수 있는 수가 없다면, 실패 처리
                }
            }
        }
        return false;
    }

    public static int checkRowAndCol(int row, int col) {
        // 가로 세로 범위 체크
        int bit = 0;
        for(int i=0; i<9; i++) {
            if(matrix[row][i]!=0) {
                bit = bit | (1 << matrix[row][i]);
            }
            if(matrix[i][col]!=0) {
                bit = bit |  (1 << matrix[i][col]);
            }
        }
        return bit;
    }

    public static int checkSquare(int row, int col) {
        // 정사각형 범위 체크
        int bit = 0;
        for(int i=(row/3)*3; i/3 == row/3; i++) {
            for(int j=(col/3)*3; j/3 == col/3; j++) {
                if(matrix[i][j]!=0) {
                    bit = bit | (1 << matrix[i][j]);
                }
            }
        }
        return bit;
    }
}
