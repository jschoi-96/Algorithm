class Solution {
    char [] chars = {'A','C','F','J','M','N','R','T'};
    boolean [] visited = new boolean[8];
    char [] arr = new char[8];
    int answer = 0;
    public int solution(int n, String[] data) {
        dfs(0, data);
        return answer;
    }
    
    public void dfs(int depth, String[] data) {
        if (depth == 8) {
            if (check(arr, data)) answer++;
            return;
        }
        
        for(int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = chars[i];
                dfs(depth + 1, data);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(char[] arr, String[] data) {
        
        for (String d : data) {
            char first = d.charAt(0);
            char second = d.charAt(2);
            char op = d.charAt(3);
            int dist = d.charAt(4) - '0';
            
            int pos1 = -1, pos2 = -1;
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] == first) pos1 = i;
                if (arr[i] == second) pos2 = i;
            }
            
            int gap = Math.abs(pos1 - pos2) - 1;
            if (op == '>') if (gap <= dist) return false;
            if (op == '=') if (gap != dist) return false;
            if (op == '<') if (gap >= dist) return false;
        }
        return true;
    }
}