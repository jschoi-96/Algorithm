import java.util.*;
class Solution {
    static boolean [] visited = new boolean[10002];
    static List<String> res = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(res);
        
        String [] answer = res.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String start, String path, int depth, String[][] tickets) {
        if (depth == tickets.length) {
            res.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            String a = tickets[i][0];
            String b = tickets[i][1];
            if (!visited[i] && start.equals(a)) { // 방문하지 않았고, 티켓의 시작 도시가 일치하는 경우에만
                visited[i] = true;
                dfs(b, path + " " + b , depth + 1, tickets);
                visited[i] = false;
            }
        }
    }
}