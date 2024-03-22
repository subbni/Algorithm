package sweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj2170 {
    static class Line {
        int start;
        int end;
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> alist = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            alist.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(alist, (l1,l2)-> {
            if(l1.start==l2.start) {
                return l1.end-l2.end;
            } 
            return l1.start-l2.start;
        });

        
        Line line = alist.get(0);
        int start = line.start, end = line.end;
        int totalLength = line.end-line.start;

        for(int i = 0; i < N; i++) {
            line = alist.get(i);
            if(line.start >= start && line.start <= end) {
                if(line.end > end) {
                    totalLength += (line.end-end);
                    end = line.end;
                } 
            } else {
                start = line.start;
                end = line.end;
                totalLength += (end-start);
            }
        }
        System.out.println(totalLength);
        //in.close();
    }
}
