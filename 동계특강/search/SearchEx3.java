package search;

import java.util.*;

class SearchEx3 {
    static int[] rangeX = {-1,1,0,0};
    static int[] rangeY = {0,0,-1,1};
   static class Pos {
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public boolean checkPos(int x, int y) {
            return this.x==x && this.y==y ? true: false;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] maps = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String str = in.next();
            for(int j = 0; j < m; j++) {
                maps[i][j] = str.charAt(j)-'0';
            }
        }
        
        Queue<Pos> q = new LinkedList<>(); // ArrayDequeue를 사용 (특히 Stack)
        Pos currentPos = new Pos(0,0,1);
        visited[0][0]=true;
        q.add(currentPos);
        while(!q.isEmpty()) {
            currentPos = q.remove();
            if(currentPos.checkPos(n-1,m-1)) {
                break;
            }
            for(int i=0;i<4;i++) {
                int nx = currentPos.x + rangeX[i];
                int ny = currentPos.y + rangeY[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]==1 && !visited[nx][ny]) {
                    // visited, distance를 따로 사용하지 않는 것 가능 
                    q.add(new Pos(nx,ny,currentPos.cnt+1));
                    visited[nx][ny]=true;
                }
            }
        }

        System.out.println(currentPos.checkPos(n-1,m-1)? currentPos.cnt: -1);
        in.close();
    }
}