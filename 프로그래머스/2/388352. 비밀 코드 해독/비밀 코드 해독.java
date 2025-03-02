import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        
        dfs(n, 0, 1, new ArrayList<>(), q, ans);
        return answer;
    }
    
    public void dfs(int n, int length, int start, List<Integer> tmp,
                   int[][] q, int[] ans) {
        if (length == 5) {
            if (isValid(tmp, q, ans)) {
                answer++;
            }
            return;
        }
        
        for(int i = start; i <= n; i++) {
            tmp.add(i);
            dfs(n, length + 1, i + 1, tmp, q, ans);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    public boolean isValid(List<Integer> tmp, int[][] q, int[] ans) {
        int idx = 0;
        for(int [] input : q) {
            int cnt = 0;
            for(int i = 0; i < input.length; i++) {
                if (tmp.contains(input[i])) cnt++;
            }
            if (cnt != ans[idx]) return false;
            idx++;
        }
        return true;
    }
}