package string;

import java.util.HashMap;
import java.util.Scanner;

public class StrEx2 {
    /*
     * 문자열 q와 p를 입력 받는다.
     * q 또는 p에서 하나의 문자만 수정(추가,삭제,변경)하여 다른 문자열을 만들 수 있는지를 확인하는 프로그램을 작성
     */
 public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("p : ");
    String p = in.nextLine();
    System.out.println("q : ");
    String q = in.nextLine();
    HashMap<Character,Integer> hm = new HashMap<>();

    for(char c: p.toCharArray()) {
        hm.put(c, hm.getOrDefault(c, 0)+1);
    }
    for(char c: q.toCharArray()) {
        hm.put(c, hm.getOrDefault(c, 0)-1);
    }

    boolean check = false;
    boolean result = true;
    for(int cnt : hm.values()) {
        if(cnt != 0) {
            if(check == true) {
                result = false;
            } else {
                check = true;
            }
        } 
    }
    System.out.println(result);
    in.close();
 }   
}
