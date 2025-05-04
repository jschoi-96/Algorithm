class Solution {
    int [] arr = new int[11];
    int[] inf;
    int[] best = new int[11];
    int max = -1;
    int max_diff = 0;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        inf = info;
        dfs(n, 0);
        
        //System.out.println(max_diff + " " + max);
        
        if (max == -1) return new int[]{-1};
        return best;
    }
    
    public void dfs(int n, int depth) {
        if (depth == 10) {
            arr[10] = n; 
            compare();
            arr[10] = 0;
            return;
        }
        
        for(int i = 0; i <= n; i++) {
            arr[depth] = i;
            dfs(n - i, depth + 1);
            arr[depth] = 0;
        }
    }
    
    public void compare() {
        int apeach = 0;
        int ryon = 0;
        
        for(int i = 0; i <= 10; i++) {
            int a = inf[i];
            int r = arr[i];
            int score = 10 - i;
            
            if (a == 0 && r == 0) continue;
            else if (a < r) ryon += score;
            else if (a >= r) apeach += score;
        }
        
        
        int diff = ryon - apeach;
        if (diff > max_diff) {
            max_diff = diff;
            max = Math.max(max, ryon);
            best = arr.clone(); // 최댓값을 갱신하는 경우 배열을 복사함.
        } 
        
        else if (diff == max_diff) { // 최댓값이 여러개인 경우 낮은 점수를 맞힌 배열을 탐색
            for(int i = 10; i >= 0; i--) {
                // 뒤에서부터 순회하며 새로운 배열의 낮은 점수가 더 많은 경우 갱신
                if (arr[i] > best[i]) {
                    best = arr.clone();
                    break;
                }
                // 반대라면 바로 break해서 탐색 중지
                else if (arr[i] < best[i]) break;
            }
        }
    }
}