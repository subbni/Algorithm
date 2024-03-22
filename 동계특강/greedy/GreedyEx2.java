package greedy;

import java.util.Scanner;

public class GreedyEx2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int sum = 0;
        for(int i = 0; i < line.length(); i++) {
            int cur = line.charAt(i)-'0';
            if(sum<=0 || cur<=1) {
                sum += cur;
            } else {
                sum *= cur;
            }
        }
        System.out.println(sum);
        in.close();
    }
}
