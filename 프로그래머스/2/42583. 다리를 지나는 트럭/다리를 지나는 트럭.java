import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int idx = 0;
        int bridgeWeight = 0;
        while(idx < truck_weights.length) {
            bridgeWeight -= bridge.poll();
            
            if (bridgeWeight + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                bridgeWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0);
            }

            time++; 
          
        }
        
        // 다리 위에 있는 트럭들을 빼줘야함
        while(bridgeWeight > 0) {
            bridgeWeight -= bridge.poll();
            time++;
        }
        //System.out.println(bridgeWeight);
        return time;
    }
}