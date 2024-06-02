import java.util.*;
class Solution {
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean [] visited = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        
        
        
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                
                if (cur.equals(target)) return answer;
                
                for(int j = 0; j < words.length; j++){
                    if (!visited[j] && check(words[j], cur)) {
                        visited[j] = true;
                        q.add(words[j]);
                    }
                }
            }
            answer++;
        }
        return 0;
    }
    
    private boolean check(String word, String cur) {
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != cur.charAt(i)) {
                count++;
            }
        }
        
        if (count == 1) return true;
        else return false;
    }
}