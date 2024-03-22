package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ArrEx1 {
    /*
     * n개의 음수와 양수를 포함하는 정수 배열 A이 주어진다.
     * 합이 주어진 숫자 k와 일치하는 모든 정수 쌍을 구하라.
     * 제한 조건: O(n^2) 알고리즘은 허용되지않음. 한 번의 scan으로 모든 해를 구하여야 함
     * Random 클래스를 이용하여 -1000000부터 1000000까지의 정수 100000개를 생성
     * seed 값은 0으로 설정
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int N = 100000;
        int[] arr = new int[N];
        Random random = new Random(0);
        for(int i = 0; i < N ; i++) {
            arr[i] = random.nextInt()%1000000;
            System.out.println(arr[i]);
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        StringBuilder sb = new StringBuilder();
        while(left < right) {
            if(arr[left]+arr[right]==k) {
                sb.append("("+arr[left]+","+arr[right]+") ");
            } else {
                
            }
        }

    }
}
