import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        
        
        dfs(new ArrayList<>() , 1, n, q, ans);
        return answer;
    }
    
    public void dfs(List<Integer> tmp, int start, int n, int[][] q, int[] ans) {
        if (tmp.size() == 5) {
            if (isValid(tmp,q,ans)) {
                //System.out.println(tmp);
                answer++;
            }
            return;
        }
        
        for(int i = start; i <= n; i++) {
            tmp.add(i);
            dfs(tmp, i + 1, n, q, ans);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    public boolean isValid(List<Integer> tmp, int[][] q, int[] ans) {
        int idx = 0;
        for(int [] arr : q) {
            int cnt = 0;
            for(int i = 0; i < arr.length; i++) {
                if (tmp.contains(arr[i])) cnt++;
            }
            
            if (cnt != ans[idx]) return false;
            idx++;
        }
        return true;
    }
}