package bitmasking;

import java.util.Scanner;

public class Boj11723 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int pos;
        int S = 0;

        StringBuilder sb = new StringBuilder();
        while(M-->0) {
            String cmd = in.next();

            if(cmd.equals("all")) {
                // 전부 1으로
                S = S | ~0;
                continue;
            } else if(cmd.equals("empty")) {
                // 전부 0으로 
                S = S&0;
                continue;
            }
            pos = in.nextInt();
            switch (cmd) {
                case "add":
                    // 0일 경우 1으로, 1일 경우 1으로
                    S = S | (1 << pos);
                    break;
                case "remove":
                    // 0일 경우 0으로, 1일 경우 0으로
                    S = S & ~(1 << pos);
                    break;    
                case "check":
                    // 해당 비트 출력
                    sb.append((S >> pos) & 1).append("\n");
                    //System.out.println();
                    break;
                case "toggle":
                    // 0일 경우 1으로, 1일 경우 0으로
                    S = S ^ (1 << pos);
                    break;      
                default:
                    break;
            }
        }
        System.out.println(sb);
        in.close();
    }
}
