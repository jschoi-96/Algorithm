import java.util.*;
class Solution {
    static List<String> res = new ArrayList<>();
    static boolean [] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(res);        
        String [] answer = res.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String start, String path, int depth, String[][] tickets) {
        if (depth == tickets.length) { // 종료 조건 -> 모든 티켓을 다 쓴 경우
            res.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            String next = tickets[i][1];
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(next, path + " " + next, depth + 1, tickets);
                visited[i] = false;
            }
        }
    }
}