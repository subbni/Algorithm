package string;

import java.util.Scanner;

public class StrEx4 {
    /*
     * 자연수 n을 3진법 상에서 앞뒤로 뒤짚은 후 이를 다시 10진법으로 표현한 수를 return
     * n은 1 이상 100,000,000 이하인 자연수
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuffer sb = new StringBuffer(Integer.toString(n,3));
        String str = new String(sb.reverse());
        int answer = Integer.parseInt(str,3);

        in.close();
        System.out.println(answer);
    }
}