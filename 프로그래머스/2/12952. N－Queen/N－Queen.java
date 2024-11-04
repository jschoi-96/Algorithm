class Solution {
    static int [] arr;
    static int answer = 0;
    public int solution(int n) {
        arr = new int[n];
        dfs(0, n);
        return answer;
    }
    
    public void dfs(int depth, int n) {
        if (depth == n) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            arr[depth] = i;
            if (isPossible(depth, n)) {
                dfs(depth + 1, n);
            }
        }
    }
    
    public boolean isPossible(int idx, int n) {
        for(int i = 0; i < idx; i++) {
            if (arr[i] == arr[idx]) return false;
            
            else if (Math.abs(i - idx) == Math.abs(arr[i] - arr[idx])) return false;
        }
        return true;
    }
}