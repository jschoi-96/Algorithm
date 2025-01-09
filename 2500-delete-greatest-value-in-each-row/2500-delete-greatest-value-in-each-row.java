class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }

        int idx = grid[0].length - 1;

        while(idx >= 0) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
            for(int i = 0; i < grid.length; i++) {
                pq.add(grid[i][idx]);
            }

            res += pq.poll(); // 최댓값 더함
            idx--;
        }
        
        return res;
    }
}