import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int n = friends.length;
        int [][] arr = new int[n][n];
        
        for (String gift : gifts) {
            String [] g = gift.split(" ");
            String giver = g[0];
            String taker = g[1];
            
            int x = 0;
            int y = 0;
            for(int i = 0; i < friends.length; i++) {
                if (friends[i].equals(giver)) x = i;
                if (friends[i].equals(taker)) { // 해당 사람과 일치하는 경우에
                    y = i;
                }
            }
            
            arr[x][y]++;
        }
        
        // 맵을 선언하여 선물 점수 저장
        
        // 준 선물 갯수를 계산
        Map<String, Integer> score = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String friend = friends[i];
            int giveCnt = 0;
            int takeCnt = 0;
            for(int j = 0; j < n; j++) {
                giveCnt += arr[i][j];
                takeCnt += arr[j][i];
            }
            
            score.put(friend, giveCnt - takeCnt);
        }
        
        // 선물 지수들을 성공적으로 저장완료
        // 그 다음엔, 다시 gift를 순회하며 준사람과 받은 사람을 비교
        
        // 맵을 선언하여 aless [joy, brad, conan] 형태로 저장 
        Map<String, Set<String>> map = new HashMap<>();
        for (String friend : friends) map.put(friend, new HashSet<>());
        
        for (String gift : gifts) {
            String [] g = gift.split(" ");
            String giver = g[0];
            String taker = g[1];
            map.get(giver).add(taker);
        }
        
//         // 맵을 돌며 선물 지수를 비교
//         for (String key : map.keySet()) {
//             Set<String> takers = map.get(key);
            
//             int giver_score = score.get(key);
//             int sum = 0;
//             for (String take : takers) {
//                 int taker_score = score.get(take);
//                 if (giver_score > taker_score) sum++;
                
//             }
//             // System.out.println(key + " " + sum);
//         }
                
        int max_cnt = 0;
        for(int i = 0; i < n; i++) {
            String giver = friends[i];
          
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                String taker = friends[j];
                
                if (arr[i][j] > arr[j][i]) cnt++;
                else if (i != j && arr[i][j] == arr[j][i]) { // 주고받은 선물 갯수가 동일하거나 주고받은 내역이 없는 경우에
                    if (score.get(giver) > score.get(taker)) {
                        cnt++;
                    }
                }
            }
            max_cnt = Math.max(max_cnt, cnt);
        }
        
        return max_cnt;
    }
}