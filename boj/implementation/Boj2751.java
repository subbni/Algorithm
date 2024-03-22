package implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> aList = new ArrayList<>(N);

        for(int i=0;i<N;i++) {
            aList.add(sc.nextInt());
        }

        Collections.sort(aList);

        for(int i=0;i<N;i++) {
            sb.append(aList.get(i)+"\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
