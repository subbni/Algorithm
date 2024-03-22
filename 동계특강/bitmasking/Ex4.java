package bitmasking;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("n: ");
        int n = in.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        String[] answer = new String[n];

        System.out.println("arr1: ");
        for(int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        System.out.println("arr2: ");
        for(int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }


        for(int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();    
            int temp = arr1[i] | arr2[i];
            for(int j = n-1; j >= 0; j--) {
                if(((temp >> j) &1) == 0 ) {
                    sb.append(" ");
                }else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }   
 

        System.out.println(answer);
        in.close();
    }
}
