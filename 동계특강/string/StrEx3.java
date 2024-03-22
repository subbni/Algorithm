package string;

import java.util.Scanner;

public class StrEx3 {
    /*
     * str1을 회전하여 str2를 만들 수 있는지 확인
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("str1 : ");
        String str1 = in.nextLine();
        System.out.print("str2 : ");
        String str2 = in.nextLine();

        String doubleStr1 = str1+str1;
        boolean result = false;
        if(doubleStr1.contains(str2)) {
            result = true;
        }

        System.out.println(result);
        in.close();
    }
}
