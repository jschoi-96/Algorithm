import java.util.*;
class Solution {
    static Map<String, ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        
        for(String s : info) {
            String [] str = s.split(" ");
            String [] languages = {str[0], "-"};
            String [] jobs = {str[1], "-"};
            String [] exps = {str[2], "-"};
            String [] foods = {str[3], "-"};
            int score = Integer.parseInt(str[4]);
            for (String language : languages)
                for(String job : jobs)
                    for(String exp : exps)
                        for(String food : foods) {
                            String [] keys = {language, job, exp, food};
                            String key = String.join(" ", keys);
                            ArrayList<Integer> arr = map.getOrDefault(key, new ArrayList<>());
                            arr.add(score);
                            map.put(key, arr);
                            
                        }
        }
        
        // 오름차순
        for(ArrayList<Integer> arr : map.values()) {
            arr.sort(null);
        }
        
        // 쿼리 조건에 맞는 지원자를 가져온다.
        int [] answer = new int[query.length];
        int idx = 0;
        for(String q : query) {
            String [] str = q.split(" and ");
            int target = Integer.parseInt(str[3].split(" ")[1]);
            str[3] = str[3].split(" ")[0]; // 숫자를 제외한 값들만 key로 가지기 위해
            String key = String.join(" ", str);
            
            if (map.containsKey(key)) {
                ArrayList<Integer> list = map.get(key);
                int start = 0;
                int end = list.size();
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (list.get(mid) >= target) {
                        end = mid;
                    }
                    else start = mid + 1;
                }
                answer[idx] = list.size() - start;
            }
            idx++;
        }
        return answer;
    }
}