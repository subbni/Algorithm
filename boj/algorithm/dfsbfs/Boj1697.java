package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Data {
    int currentPos;
    int count;
    Data(int currentPos, int count) {
        this.currentPos = currentPos;
        this.count = count;
    }
}

public class Boj1697 {
    static int MAX_POS = 100000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();   // 현재 나의 위치
        int M = in.nextInt();   // 목표 위치
        boolean[] visited = new boolean[MAX_POS+1];
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(N, 0));
        while(!queue.isEmpty()) {
            Data data = queue.remove();
            if(data.currentPos==M) {
                System.out.println(data.count);
                break;
            }
            if(data.currentPos+1 <= MAX_POS && !visited[data.currentPos+1]) {
                queue.add(new Data(data.currentPos+1, data.count+1));
                visited[data.currentPos+1] = true;
            }
            if(data.currentPos*2 <= MAX_POS && !visited[data.currentPos*2]) {
                queue.add(new Data(data.currentPos*2, data.count+1));
                visited[data.currentPos*2] = true;
            }
            if(data.currentPos-1 >= 0 && !visited[data.currentPos-1]) {
                queue.add(new Data(data.currentPos-1, data.count+1));
                visited[data.currentPos-1] = true;
            } 
        }
        in.close();
    }
}
