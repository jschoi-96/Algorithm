import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // 1. 유효기간 정보 저장
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            String [] str = term.split(" ");
            map.put(str[0], Integer.parseInt(str[1]));
        }
        
        // 2. terms 날짜 분리 및 계산
        
        int idx = 0;
        int [] arr = new int[privacies.length];
        for(String p : privacies) {
            String [] str = p.split(" ");
            String st = str[0];
            String key = str[1];
            
            // System.out.println(st + " " + key);
            String [] s = st.split("\\.");
            int year = Integer.parseInt(s[0]);
            int month = Integer.parseInt(s[1]);
            int day = Integer.parseInt(s[2]);
            
            int cur = year*12*28 + 28*month + day;
            int next = map.get(key)*28; // 유효기간 -> 달 계산
            System.out.println("next: " + next);
            
            int valid = cur + next; // 유효기간 계산
            
            arr[idx++] = valid;
        }
        
        // 3. today 값 변환
        String [] str = today.split("\\.");
        int t = Integer.parseInt(str[0])*28*12 + Integer.parseInt(str[1])*28 + Integer.parseInt(str[2]);
        
        // 4. int 배열을 순회하며 계산
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            if (arr[i] <= t) {
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
}