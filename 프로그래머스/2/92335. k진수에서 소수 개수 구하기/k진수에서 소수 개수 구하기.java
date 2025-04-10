import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Long.toString(n, k);
        // System.out.println(s);
        
        String tmp = "";
        int idx = 0;
        
        String [] str = s.split("0");
        for(String st : str) {
            if (isPossible(st)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPossible(String s) {
        if (s.length() == 0) return false;
        long n = Long.parseLong(s);
        if (n == 0 || n == 1) return false;
        
        for(long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}