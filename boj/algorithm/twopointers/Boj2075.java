package twopointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2075 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur;
            while(st.hasMoreTokens()) {
                cur = Integer.parseInt(st.nextToken());
                if(pq.size() >= n) {
                    if(pq.peek() < cur) {
                        pq.poll();
                        pq.add(cur);
                    }
                } else {
                    pq.add(cur);
                }
            }
        }
        System.out.println(pq.poll());
    }
}
