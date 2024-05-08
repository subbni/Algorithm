package lis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj2565_전깃줄 {
    static int[] memo;
    static class Wire {
        int from;
        int to;
        public Wire(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Wire> wireList = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            wireList.add(new Wire(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        
        Collections.sort(wireList, (o1,o2)-> {
            return o1.from - o2.from;
        });

        memo = new int[n+1];
        int len = 0;
        int idx = 0;
        for(int i=0; i<n; i++) {
            int cur = wireList.get(i).to;
            if(cur > memo[len]) {
                len++;
                memo[len] = cur;
            } else {
                idx = binarySearch(0, len, cur);
                memo[idx] = cur;
            }
        }

        System.out.println(n-len);
    }

    static int binarySearch(int left, int right, int key){
        int mid = 0;
        while(left < right) {
            mid = (left+right)/2;
            if(memo[mid] < key) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
