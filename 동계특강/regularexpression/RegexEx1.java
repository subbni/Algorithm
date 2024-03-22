package regularexpression;

import java.util.Scanner;

public class RegexEx1 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String str = new String();
        String regex = "^010-[0-9]{4}-[0-9]{4}$";
        while(true) {
            System.out.print("휴대폰 번호를 입력하세요(종료는 q:): ");
            str = in.nextLine();
            if(str.equals("q")) {
                break;
            }
            if(str.matches(regex)) {
                System.out.println("정확한 전화번호 양식입니다.");
            } else {
                System.out.println("잘못된 전화번호 양식입니다.");
            }
        }
        in.close();
    }
}
