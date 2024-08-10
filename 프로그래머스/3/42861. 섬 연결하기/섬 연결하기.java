import java.util.*;
class Solution {
    static int [] parent;
    static int res = 0;
    public int solution(int n, int[][] costs) {
        int answer = 0;
                
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a,b) -> (a[2] - b[2]));
        // 가중치가 낮은 애들부터 정렬 
        
        for(int [] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            if (find(a) != find(b)) {
                union(a,b);
                res += c;
            }
            //System.out.println(c);
            
        }
        return res;
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
    
    public int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        
        return find(parent[n]);
    }
}