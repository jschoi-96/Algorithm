import java.util.*;
class Solution {
    
    static int ans = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean [] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
    
    public void dfs(String cur, String target, String [] words, boolean [] visited, int cnt) {
        if (cur.equals(target)) {
            ans = Math.min(ans, cnt);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if (!visited[i] && check(cur, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited,  cnt + 1);
                visited[i] = false;
            }
        }
    }
   
    
    public boolean check(String begin, String word) {
        int ans = 0;
        for(int i = 0; i < begin.length(); i++){
            if (begin.charAt(i) != word.charAt(i)) {
                ans++;
            }
            if (ans > 1) return false;
        }
        return true;
    }
}