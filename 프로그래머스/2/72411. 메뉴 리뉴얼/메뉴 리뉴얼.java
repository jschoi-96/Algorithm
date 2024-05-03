import java.util.*;
class Solution {
    static Map<String,Integer> map = new HashMap<>();
    static List<String> answerList = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {   
        
        // 1. 각 order 정렬
        for(int i = 0; i < orders.length; i++) {
            char [] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }
        
        // 2. 각 order를 기준으로 courseLength 만큼 조합 만들기
        for(int courseLength : course) {
            for (String order : orders) {
                dfs("", order, courseLength);
            }
            
            // 3. 가장 많은 조합을 answer에 저장
            
            if (!map.isEmpty()) {
                // 4. 해쉬맵의 value를 리스트에 담고 max값을 찾는다.
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);
                
                if (max > 1) {
                    for(String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                map.clear();
            }
        }
        
        Collections.sort(answerList);
        String [] answer = new String[answerList.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    // order - 현재까지 조합된 course
    // others - 사용되지 않은 알파벳
    // count - 몇 개를 조합해야 하는지
    private void dfs(String order, String others, int count) {
        
        if (count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        
        for(int i = 0; i < others.length(); i++) {
            // i번째 까지는 조합을 했으므로, i+1부터는 사용되지 않은 알파벳
            dfs(order + others.charAt(i), others.substring(i+1), count - 1);
        }
    }
}