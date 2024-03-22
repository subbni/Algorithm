package greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GreedyEx3 {
    // programmers 42884
    static class Car {
        int start;
        int end;
        public Car(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Car> carList = new ArrayList<>();
        boolean[] covered = new boolean[N];

        for(int i = 0; i < N; i++) {
            carList.add(new Car(in.nextInt(), in.nextInt()));
        }
        
        Collections.sort(carList, (c1,c2)-> {
            return c1.end-c2.end;
        });

        for(int i = 0; i < N; i++) {
            Car car = carList.get(i);
            if(covered[i]) continue;
            for(int j = i+1; j < N; j++) {
                if(!covered[j] && carList.get(j).start >= car.start && carList.get(j).start <= car.end) {
                    covered[j] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(!covered[i]) cnt++;
        }
        System.out.println(cnt);
        in.close();
    }
}
