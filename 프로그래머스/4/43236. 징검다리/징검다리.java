import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int lo = 1, hi = distance;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            
            int prev = 0;
            int remove = 0;
            for(int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) { // 바위 사이의 거리가 mid보다 작은경우, 돌을 없애준다.
                    remove++; 
                }
                else {
                    prev = rocks[i]; //
                }
            }
            
            if (distance - prev < mid) remove++;
            
            if (remove > n) { // 제거된 갯수가 너무 많다면 상한점 낮추기
                hi = mid - 1;
            }
            
            else { 
                answer = mid;
                lo = mid + 1;
            }
            
            // System.out.println(lo + " " + hi);
        }
        
        return answer;
    }
}