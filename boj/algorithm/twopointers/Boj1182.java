package twopointers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1182 {
    static int N,S;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0;
        int cnt = 0;
        int sum = 0;
        while(s < N) {
            if(sum == S) {
                cnt++;
                sum -= arr[s];
                s++;
            } else if(sum > S) {
                sum -= arr[s];
                s++;
            } else {
                if(e+1 < N) {
                    e++;
                    sum += arr[e];
                } else {
                    sum -= arr[s];
                    s++;
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
