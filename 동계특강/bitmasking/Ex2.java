package bitmasking;

import java.util.Scanner;

public class Ex2 {
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

        if(k > 0) {
            answer = answer | (1 << k);
        } else if(k < 0) {
            k = (-1)*k;
            answer = answer & ~(1 << k);
        } else {
            answer = answer ^ (1 << k); 
        }

        System.out.println(answer);
        in.close();
    }
}
