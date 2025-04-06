import java.util.*;
class Solution {
    /*
      stages 20만 이하, 따라서 O(nlogn) 미만으로 구현해야함  
      실패율: 스테이지에 도달했으나 클리어x / 스테이지 도달
      1. stages를 순회하며 해쉬맵에 [stage, 클리어하지 못한 사람] 형태로 저장
      2. 해쉬맵을 순회하며 전체 사람의 수인 stages 길이에서 클리어하지 못한 사람을 계속 빼준다.
      3. 배열 선언하여 [stage, 실패율]로 저장하고, 실패율을 기준으로 내림차순
      4. 실패율 내림차순하되, 실패율이 같은 경우엔 스테이지가 작은 순서대로.
    */
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 1; i <= N; i++) map.put(i, 0);
        
        for(int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            if (stage > N) continue; // 모든 스테이지를 통과한 경우엔 저장 x
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }
        
        int n = stages.length;
        double[][] res = new double[N][2];
        int idx = 0;
        for(Integer stage : map.keySet()) {
            double fail = (double) map.get(stage) / n;
            n -= map.get(stage);
            if (n <= 0) n = 1;
            //System.out.println(fail);
            res[idx][0] = stage;
            res[idx][1] = fail;
            idx++;
        }
        
        Arrays.sort(res, (a,b) -> {
            int cmp = Double.compare(b[1], a[1]);
            if (cmp != 0) return cmp;
            return Double.compare(a[0], b[0]); 
        });
        
        for(int i = 0; i < res.length; i++) {
            answer[i] = (int) res[i][0];
        }
                
        return answer;
    }
}