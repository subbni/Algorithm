package bitmasking;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("십진수 : ");
            int number = in.nextInt();
            if(number<0) {
                break;
            }
            System.out.println(Integer.toBinaryString(number));
        }
        in.close();
    }   
}
