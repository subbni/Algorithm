package regularexpression;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexEx4 {
    /*
     * programmers 17682 다트게임
     */
    public static void main(String[] args) {
        solution("1S2D*3T");
    }

    static public int solution(String dartResult) {
        String regex = "(\\d{1,2})([SDT])([#*]{0,1})";
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(dartResult);
        
        int[] score = new int[3];

        int i = 1;
        while(m.find()) {
            score[i] = Integer.parseInt(m.group(i));
            String bonus = m.group(i+1);
            switch (bonus) {
                case "D":
                    break;
                case "T":
                    break;
                default:
                    break;
            }

            if(m.group(i+2).matches("[#*]")) {
                String option = m.group(i+2);
                if(option.equals("#")) {

                } else {
                    
                }
            }
        }

        return score[0]+score[1]+score[2];
    }
}
