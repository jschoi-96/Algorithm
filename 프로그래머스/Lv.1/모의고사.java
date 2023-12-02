import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        
        // answers의 길이는 최대 10000
        // 21232 42521 24252
        
        int [] first = {1, 2, 3, 4, 5};
        int [] second = { 2, 1, 2, 3, 2, 4, 2, 5};
        int [] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int total1 = 0; int total2 = 0; int total3 = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < answers.length; i++){
            if (first[i % 5] == answers[i]) total1++;
            if (second[i % 8] == answers[i]) total2++;
            if (third[i % 10] == answers[i]) total3++;
        }
        
        int total = Math.max(total1, Math.max(total2, total3));
        
        if (total == total1) list.add(1);
        if (total == total2) list.add(2);
        if (total == total3) list.add(3);
        
        int [] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
