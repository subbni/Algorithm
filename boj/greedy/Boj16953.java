package greedy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Boj16953 {
    static class Data {
        int sum;
        int cnt;
        public Data(int sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int answer = -1;

        Queue<Data> queue = new ArrayDeque<>();

        queue.add(new Data(A,1));

        while(!queue.isEmpty()) {
            Data data = queue.poll();
            if(data.sum == B) {
                answer = data.cnt;
                break;
            }
            if(data.sum*2 <= B) {
                queue.add(new Data(data.sum*2, data.cnt+1));
            } 
            if(Integer.parseInt(data.sum+"1") <= B) {
                queue.add(new Data(Integer.parseInt(data.sum+"1"), data.cnt+1));
            }
        }

        System.out.println(answer);
        in.close();
    }
}
