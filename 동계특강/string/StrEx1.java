package string;

import java.util.HashSet;
import java.util.Scanner;

public class StrEx1 {
    // 문자열이 고유 문자만 포함될 경우 true를 반환, 그렇지 않으면 false를 반환한다.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        HashSet<Character> hs = new HashSet<>();
        boolean result = true;

        for(char c : str.toCharArray()) {
            if(c==' ') {
                continue;
            } else if(hs.contains(c) == true) {
                result = false;
                break;
            } else {
                hs.add(c);
            }
        }

        System.out.println(result);
        in.close();
    }
}
