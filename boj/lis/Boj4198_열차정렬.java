package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Boj4198_열차정렬 {
    static LinkedList<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new LinkedList<>();
        if(N > 0) {
            list.add(arr[0]);
        }
        for(int i=1; i<N; i++) {
            int pos = binarySearch(0, list.size(), arr[i]);
            if(pos == 0 || pos == list.size()) {
                list.add(pos,arr[i]);
            } else if(pos == 1) {
                list.removeFirst();
                list.addFirst(Math.max(list.get(0),arr[i]));
            } else if(pos == list.size()-2) {
                list.removeLast();
                list.addLast(Math.min(list.get(list.size()-1),arr[i]));
            }
        }
        System.out.println(list.size());
    }

    static int binarySearch(int left, int right, int key) {
        int mid = (left+right)/2;
        while(left < right) {
            mid = (left+right)/2;
            if(mid >= list.size()) return list.size();
            if(list.get(mid) < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
