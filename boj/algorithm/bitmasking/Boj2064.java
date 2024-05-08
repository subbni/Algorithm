package bitmasking;

import java.util.Scanner;

public class Boj2064 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] address = new int[n];
        int endPos = 0; // 네트워크 주소가 끝난 다음 위치 
        // 1. n개의 주소 배열에 저장
        for(int i = 0; i < n; i++) {
            String[] nums = in.next().split("\\.");
            for(int j = 0; j < 4; j++) {
                address[i] = address[i] << 8;
                address[i] = address[i] | Integer.parseInt(nums[j]);
            }
        }
        // 2. 네트워크 주소 & 마스크 구하기
        int netAddr = address[0];
        for(int i = 1; i < n; i++) {
            netAddr = netAddr & address[i];
            for(int j = 31; j > endPos; j--) {
                // i-1의 주소의 j번째 비트와 현재 주소의 j번째 비트가 같은지 다른지 확인
                if((address[i-1] >> j & 1) != (address[i] >> j & 1)) {
                    endPos = j;
                    break;
                }
            }
        }
        // 네트워크 마스크 : endPos의 왼쪽 비트는 1으로, endPos부터 오른쪽 비트는 0으로 처리
        // 네트워크 주소 : endPos부터 오른쪽 비트는 0으로 전부 처리 
        int netMask = ~0;
        if(endPos==31) {
            netMask = 0;
        } else if(endPos>0) {
            netMask = netMask << endPos;
            netMask = netMask & ~(1 << endPos+1);
        }

        netAddr = netAddr & netMask;

        StringBuilder answer = new StringBuilder();
        int tmp = 0;
        for(int i = 24; i>=0 ; i-=8) {
            // 원하는 비트를 가장 오른쪽으로 끌어온다.
            tmp = netAddr >> i;
            // 하위 8비트만 1인 변수와 & 연산
            tmp = tmp & ~(~0 << 8);
            answer.append(String.valueOf(tmp)).append(".");
        }
        answer.deleteCharAt(answer.length()-1);
        answer.append("\n");
        for(int i = 24; i>=0 ; i-=8) {
            tmp = netMask >> i;
            tmp = tmp & ~(~0 << 8);
            answer.append(String.valueOf(tmp)).append(".");
        }
        answer.deleteCharAt(answer.length()-1);

        System.out.println(answer);
        in.close();
    }  
}   
