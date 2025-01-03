class Solution {
    // town judge -> 간선이 자기 자신에게 돌아오지만, 다른 정점으론 가지않음.
    // town judge 정점을 가르키는 간선은 n-1개가 되어야 함. 
    List<List<Integer>> graph = new ArrayList<>();
    int [] deg;
    public int findJudge(int n, int[][] trust) {

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        deg = new int[n+1];

        for(int [] t : trust) {
            int u = t[0];
            int v = t[1];
            graph.get(u).add(v); 
            deg[v]++;
        }

        for(int i = 1; i <= n; i++) {
            if (graph.get(i).isEmpty() && deg[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}