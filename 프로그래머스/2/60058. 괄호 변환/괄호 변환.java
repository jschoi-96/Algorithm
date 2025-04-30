import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        
        if (p.isEmpty()) return answer;
        int idx = getIdx(p);
        
        String u = p.substring(0, idx+1);
        String v = p.substring(idx+1);
        // System.out.println(u + " " + v);
        
        if (isCorrect(u)) {
            // v에 대해 1단계부터 수행, 문
            return u + solution(v);
        }
        
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            
            String s = u.substring(1, u.length() - 1);
            String res = reverse(s);
            sb.append(res);
            // sb.deleteCharAt(0);
            // sb.deleteCharAt(sb.length() - 1);
            
            return sb.toString();
            
        }
        
        //return answer;
    }
    
    public int getIdx(String p) {
        int cnt = 0;
        for(int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') cnt++;
            else cnt--;
            if (cnt == 0) return i;
        }
        return -1; // 못찾았으면 -1리턴
    }
    
    public boolean isCorrect(String p) {
        Stack<Character> s = new Stack<>();
        for(char c : p.toCharArray()) {
            if (c == '(') s.add(c);
            else {
                if (s.isEmpty()) return false;
                s.pop();
            }
        }
        return s.isEmpty();
    }
    
    public String reverse(String s) {
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c == ')') res.append("(");
            else res.append(")");
        }
        return res.toString();
    }
}