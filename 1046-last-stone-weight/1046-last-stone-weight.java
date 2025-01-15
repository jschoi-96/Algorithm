class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int stone : stones) pq.add(stone);

        while(pq.size() > 1) {
            int x = pq.poll();
            int y = pq.peek();
            if (x == y) pq.poll();
            else {
                pq.poll();
                pq.add(Math.abs(y - x));
            }
        }

        if (!pq.isEmpty()) return pq.peek();
        return 0;
    }
}