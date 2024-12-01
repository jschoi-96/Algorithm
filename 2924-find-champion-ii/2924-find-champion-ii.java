class Solution {
    public int findChampion(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int [] deg = new int[n];
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges) {
            int strong = edge[0];
            int weak = edge[1];
            graph.get(strong).add(weak);
            deg[weak]++;
        }
        // 0 -> 1
        // 1 -> 2

        // 0 -> 2
        // 1 -> 2, 3
        
        int res = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                res = i;
                count++;
            }

            if (count >= 2) return -1;
        }
        return res;
    }
}