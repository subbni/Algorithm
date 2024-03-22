package bitmasking;

import java.util.Scanner;

public class Ex3 {
    /*
     * 32비트 정수 p,q와 위치 x,y(x<y)를 입력받는다.
     * q의 비트에서 x와 y사이의 비트를 p의 비트로 대체하는 코드를 작성하라.
     * 단, x와 y 사이에 p의 모든 비트를 넣을 수 있다고 가정한다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        // 1. q의 x에서 y까지의 비트를 0으로 초기화 시킨다. => 0과 & 연산
        int mask = 0;
        for(int i = x; i <= y; i++) {
            mask = mask | (1<<i);
        }
        mask = ~(mask);
        q = q&mask;
        System.out.println(Integer.toBinaryString(q));
        // 2. p의 첫 번째 비트를 q의 x번째 비트부터 y번째 비트와 | 연산한다.
        for(int i = x; i<= y; i++) {
            int temp = (p >> i) << i;
            q = q | temp;
        }
        System.out.println(Integer.toBinaryString(q));
        System.out.println(q);
        in.nextInt();
    }
}
