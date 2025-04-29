import java.util.*;
class Solution {
    static int max = 0;
    public String[] solution(String[] orders, int[] course) {
                
        Map<Integer, List<Character>> map = new HashMap<>();
        for(int i = 0; i < orders.length; i++) {
            map.put(i+1, new ArrayList<>());
        }
        
        int idx = 1;
        for(String order : orders) {
            
            for(int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);
                map.get(idx).add(c);
            }
            
            Collections.sort(map.get(idx)); // 여기서 오름차순으로 정렬
            idx++;
        }
        
        for(Integer key : map.keySet()) {
            //System.out.println(key + " " + map.get(key));
        }
        
        // 길이 순회하며 백트래킹을 돌리고, 가장 많이 등장한 코스를 찾는다. 
        
        List<String> res = new ArrayList<>();
        for(int len : course) {
            Map<String, Integer> tmp = new HashMap<>();
            max = 0; // 최대 등장횟수
            for(Integer key : map.keySet()) {
                dfs(len, map.get(key), tmp, 0, 0, new ArrayList<>());
            }
            
            List<String> keys = new ArrayList<>(tmp.keySet());
            for(String key : keys) {
                if (max >= 2 && tmp.get(key) == max) {
                    res.add(key);
                }
            }
        }
        
        Collections.sort(res);
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }
    
    public void dfs(int len, List<Character> list, Map<String, Integer> tmp, int curLen, int idx, List<Character> cur) {
        if (curLen == len) {
            String key = "";
            for(char c : cur) {
                key += c;
            }
            tmp.put(key, tmp.getOrDefault(key, 0) + 1);
            max = Math.max(max, tmp.get(key));
            //System.out.println(key);
            return;
        }
        
        //System.out.println("?");
        for(int i = idx; i < list.size(); i++) {
            cur.add(list.get(i));
            dfs(len, list, tmp, curLen + 1, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}