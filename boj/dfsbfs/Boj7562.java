package dfsbfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;
    int count;
    Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Boj7562 {
    static int[] rangeX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] rangeY = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();   // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int L = in.nextInt();   // 체스판의 한 변의 길이
            boolean[][] visited = new boolean[L][L];
            int currentX = in.nextInt();
            int currentY = in.nextInt();
            int goalX = in.nextInt();
            int goalY = in.nextInt();

            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(currentX, currentY, 0));
            visited[currentX][currentY] = true;

            while(!queue.isEmpty()) {
                Point p = queue.poll();
                if(p.x == goalX && p.y == goalY) {
                    sb.append(p.count).append("\n");
                    break;
                }

                for(int i = 0; i < 8; i++) {
                    int dx = p.x + rangeX[i];
                    int dy = p.y + rangeY[i];
                    if(dx>=0 && dx<L && dy>=0 && dy<L) {
                        if(!visited[dx][dy]) {
                            visited[dx][dy] = true;
                            queue.add(new Point(dx, dy, p.count+1));
                        }
                    }
                }
            }
        }
        System.out.print(sb);
        in.close();        
    }
}
