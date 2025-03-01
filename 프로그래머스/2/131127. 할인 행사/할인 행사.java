import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = discount.length;
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> wantMap = new HashMap<>(); // 열흘간의 품목을 저장하는 맵
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
            wantMap.put(want[i], 0); // 초기화
        }

        int days = 0;
        
        for(int i = 0; i < n; i++) {
            wantMap.put(discount[i], wantMap.getOrDefault(discount[i], 0) + 1); // 원하는 제품 품목 추가 
            days++;
            boolean flag = true;
            if (days == 10) { // 열흘 될 때 체크
                for (String product : want) {
                    if (map.get(product) != wantMap.get(product)) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) answer++;
                int start = i - days + 1;
                wantMap.put(discount[start], wantMap.getOrDefault(discount[start], 0) - 1);
                days--;
            }
        }
        return answer;
    }
}