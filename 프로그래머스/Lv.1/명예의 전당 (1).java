import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        
        // 1. 배열을 순회하며 최솟값을 발표 점수에 더해줌.
        // 2. k의 숫자를 넘어설 때, 명예의 전당에서 제일 낮은 점수를 score와 비교
        // 3. 만약에 score 점수가 더 크다면, 대체.
        int [] temp = new int[k];
        int lowest = score[0];
        
        for(int i = 0; i < score.length; i++) {
            if (i < k) {
                temp[i] = score[i];
                lowest = Math.min(lowest, score[i]);
                answer[i] = lowest;
            }
            
            else {
                Arrays.sort(temp); // 순서대로 정렬해줌.
                if (score[i] > temp[0]) { // 기존 점수보다 더 클 때
                    temp[0] = score[i]; //  150 20 100
                }
                Arrays.sort(temp); // 순서대로 정렬해줌.
                answer[i] = temp[0];
            }
        }

        return answer;
    }
}

// PriorityQueue를 이용한 풀이

import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int [score.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < score.length; i++){
            pq.add(score[i]); 
            
            if (pq.size() > k) {
                pq.poll(); // 제일 작은 값을 내보낸다
            }
            
            answer[i] = pq.peek(); 
        }
        return answer;
    }
}
