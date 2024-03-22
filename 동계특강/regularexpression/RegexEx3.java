package regularexpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx3 {
    /* 
    * 공백, a-z, 0-9 로 이루어진 문자열을 입력 받는다. 
    * 이 문자열에서 정수를 추출하는 코드를 작성하라.
    */ 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String regex = "([0-9a-z])*?";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        
        StringBuilder sb = new StringBuilder();
        for(int i=1;m.find();i++) {
            sb.append(m.group(i).replaceAll("[a-z]", "")).append(" ");
        }    
        System.out.println(sb);   
        in.close();
    }
}
 