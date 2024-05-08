package swea.d2;

import java.io.*;
import java.util.HashMap;

public class Solution1928 {
    static HashMap<Character,Integer> encodingMap = new HashMap<>();
    public static void main(String[] args) throws Exception{
        setEncodingMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        /*
         * 1. String으로 받아온 각 char들을 표에서 찾은 숫자대로, 6bit형태로 연결한다.
         * 2. 연결된 비트들을 8비트씩 읽고, 이를 아스키코드에 대입하여 다시 연결한다.
         */
        for(int t=1; t<=T; t++) {
           String input = br.readLine();
           StringBuilder sb = new StringBuilder();
           StringBuilder result = new StringBuilder();
           for(char c: input.toCharArray()) {
            sb.append(getBinaryString((int)(encodingMap.get(c))));
           }
           for(int i=0; i<sb.length(); i+=8) {
            int num = getDecimalNumber(sb.substring(i, i+8));
            result.append((char)num);
           }
           bw.write("#"+t+" ");
           bw.write(result.toString());
           bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String getBinaryString(int input) {
        StringBuilder sb = new StringBuilder();
        while(input / 2 > 0) {
            sb.append(input%2);
            input = input/2;
        }
        sb.append(input);
        while(sb.length()<6) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }

    static int getDecimalNumber(String binary) {
        int result = 0;
        int cur;
        for(int i=binary.length()-1; i>=0; i--) {
            cur = binary.charAt(i)-'0';
            cur *= Math.pow(2,binary.length()-i);
            result += cur ;
        }
        return result;
    }

    static void setEncodingMap() {
        for(int i=0; i<26; i++) {
            char uppeercase = (char)((char)'A'+i);
            char lowercase = (char)((char)'a'+i);
            encodingMap.put(uppeercase,i);
            encodingMap.put(lowercase,i+26);
         }
         for(int i=0;i<10;i++) {
            char number = (char)((char)'0'+i);            
            encodingMap.put(number,i+52);
         }
         encodingMap.put('+', 62);
         encodingMap.put('/', 63);

    }
}
