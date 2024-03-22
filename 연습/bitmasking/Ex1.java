package bitmasking;

import java.util.Scanner;

public class Ex1 {
    /*
     * k가 양수이면, 위치 k에 있는 n의 비트값을 1로 설정한다.
     * k가 음수이면, 위치 -k에 있는 n의 비트값을 0으로 설정한다.
     * k가 0이면, 위치 k에 있는 n의 비트값을 0이면 1으로, 1이면 0으로 설정한다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int answer = n;

        if(k>0) {
            answer = answer | (1 << k);
        } else if(k<0) {
            // 나머지는 전부 1이고 k번째만 0인 
            answer = answer | ~(1 << -k);
        } else {
            // xor 연산시 반대로 만들어주고 싶으면 1을, 그대로면 0을 
            answer = answer ^ (1 << k);
        }
        System.out.println(answer);
        in.close();
    }
}
