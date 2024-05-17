import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        // 큐에 들어가는 조건은?
        // 뒤에가 100이 되더라도 앞이 100이 안되면 push 불가 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            q.add(i);
        }
   
        List<Integer> list = new ArrayList<>();
        int days = 0; // 현재 시간을 타나내는 변수
        int count = 0; // 얼마나 많은 작업이 동시에 완료되는지 세는 변수
        int expr = 0;
        while(!q.isEmpty()) {
            int idx = q.poll();
            
            if ((100 - progresses[idx]) % speeds[idx] == 0) {
                expr = ((100 - progresses[idx]) / speeds[idx]);
            }
            
            else {
                expr = ((100 - progresses[idx]) / speeds[idx]) + 1;
            }
            
            if (expr > days) { // 완료되는데 시간이 현재보다 더 걸린다면
                if (days != 0) { 
                    list.add(count);
                    count = 0;
                }
                days = expr; // 값을 할당
            }
            count++;
        }
        
        list.add(count); // 마지막 추가 
        int [] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}