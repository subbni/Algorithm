package greedy;

import java.util.HashMap;
import java.util.Scanner;

public class Boj1946 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        StringBuilder sb = new StringBuilder();

        while(T-->0) {
            int N = in.nextInt();
            HashMap<Integer,Integer> hm = new HashMap<>();
    
            for(int i = 0; i < N; i++) {
                hm.put(in.nextInt(), in.nextInt());
            }
    
            int min = N+1;
            int cnt = 0;
            for(int i = 1; i <= N; i++) {
                if(hm.get(i)<min) {
                    min = hm.get(i);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        
        System.out.println(sb);
        in.close();
    }  
}
