package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj1931 {
    static class Meeting {
        int start;
        int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        ArrayList<Meeting> meetingList = new ArrayList<>(N);

        for(int i = 0; i < N ; i++) {
            meetingList.add(new Meeting(in.nextInt(), in.nextInt()));
        }

        Collections.sort(meetingList, (m1,m2)-> {
            if(m1.end == m2.end) {
                return m1.start-m2.start;
            }
            return m1.end-m2.end;
        });

        int endTime = 0, cnt = 0;
        for(Meeting meeting: meetingList) {
            if(endTime <= meeting.start) {
                endTime = meeting.end;
                cnt++;
            }
        }
        System.out.println(cnt);
        in.close();
    }

}