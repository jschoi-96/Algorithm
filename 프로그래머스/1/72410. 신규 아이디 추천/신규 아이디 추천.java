import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        String one = "";
        for(char c : new_id.toCharArray()) {
            one += Character.toLowerCase(c);
        }
        
        // 2단계
        String two = "";
        for(char c : one.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' 
                || c == '_' || c == '.') two += c;
        }
        
        // 3단계
        String three = "";
        three += two.charAt(0);
        for(int i = 1; i < two.length(); i++) {
            if (two.charAt(i) == '.' && two.charAt(i-1) == '.') continue;
            three += two.charAt(i);
        }
        
        String four = "";
        for(int i = 0; i < three.length(); i++) {
            if (i == 0 || i == three.length() - 1) {
                if (three.charAt(i) == '.') continue;
                else four += three.charAt(i);
            }
            else four += three.charAt(i);
        }
        
        
        // System.out.println(four);
        
        String five = "";
        if (four.length() == 0) five = "a";
        else five = four;
        
        // 6단계
        String six = five;
        if (five.length() >= 16) {
            six = five.substring(0, 15);
            if (six.endsWith(".")) six = six.substring(0, six.length() - 1);
        }
        
        // System.out.println(four);
        
        String sev = six;
        while(sev.length() < 3) {
            sev += sev.charAt(sev.length() - 1);
        }
        
        return sev;
    }
}