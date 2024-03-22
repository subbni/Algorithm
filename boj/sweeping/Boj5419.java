package sweeping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj5419 {
    static class Island {
        int x;
        int y;
        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Island> alist = new ArrayList<>();
            while(N-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                alist.add(new Island(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(alist, (i1,i2)-> {
                if(i1.x == i2.x) {
                    return i2.y-i1.y;
                }
                return i1.x-i2.x;
            });
            int cnt = 0;
            for(int i = 0; i < alist.size(); i++) {
                Island island = alist.get(i);
                for(int j = i+1; j < alist.size(); j++) {
                    if(island.y >= alist.get(j).y) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
