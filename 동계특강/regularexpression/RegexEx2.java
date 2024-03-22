package regularexpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx2 {
    // MM/DD/YYYY 형식으로 표기된 날짜를 입력받은 후, YYYYMMDD 형태로 변경하여 출력
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String regex = "(\\d{2})/(\\d{2})/(\\d{4})";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        StringBuilder sb = new StringBuilder();
        while(m.find()) {
            sb.append(m.group(3)).append(m.group(1)).append(m.group(2));
        }
        
        System.out.println(sb);
        in.close();
    }
}
