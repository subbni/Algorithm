package bitmasking;

import java.util.Scanner;


public class Ex1 {    
    // 32비트 정수 n과 자리수 k를 입력받아 위치 k에 있는 n의 비트값을 출력
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        //System.out.println((n & (1<<k)) == 0 ? 0 : 1);
        // 교수님 답안
        System.out.println((n >> k) & 1);
        in.close();
    }
}
