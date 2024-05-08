package swea.d3;


import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution1244
{
    static int max;
    static char[] arr;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            arr = sc.next().toCharArray();
            int n = sc.nextInt(); 
            max = Integer.MIN_VALUE;
            dfs(0,n);
            System.out.printf("#%d %d",test_case,max);
            System.out.println();                       
		}
        sc.close();
	}

    public static void dfs(int idx, int n) {
        if(n==0) {
            // max인지 확인하기
            int cur = Integer.parseInt(new String(arr));
            if(cur > max) {
                max = cur;
            }
            return;
        } 

        for(int i=idx; i<arr.length-1; i++) { // 어째서 idx부터 시작해도 되는걸까 ..?  
            for(int j=i+1; j<arr.length; j++) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                dfs(i,n-1);
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}