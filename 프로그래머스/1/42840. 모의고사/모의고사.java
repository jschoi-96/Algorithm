import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int [] one = {1,2,3,4,5};
        int [] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int [] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
                
        int one_ans = 0; int two_ans = 0; int three_ans = 0;
        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) one_ans++;
            if (answers[i] == two[i % two.length]) two_ans++;
            if (answers[i] == three[i % three.length]) three_ans++;
        }
        
        int res = Math.max(one_ans, Math.max(two_ans, three_ans));
        List<Integer> list = new ArrayList<>();
        
        if (one_ans == two_ans && two_ans == three_ans) {
            int [] answer = new int[3];
            answer[0] = 1; answer[1] = 2; answer[2] = 3;
            return answer;
        }
        
        if (res == one_ans) list.add(1);
        if (res == two_ans) list.add(2);
        if (res == three_ans) list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);

        return answer;
    }
}