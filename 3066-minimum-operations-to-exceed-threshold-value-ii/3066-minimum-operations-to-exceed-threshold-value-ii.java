class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num : nums) pq.add((long) num);

        int cnt = 0;
        while(pq.size() > 1 && pq.peek() < k) { // pq의 최솟값이 k보다 작을동안 
            long num1 = pq.poll();
            long num2 = pq.poll();
            long sum = num1 * 2 + num2;
            pq.add(sum);
            // System.out.println(sum);
            cnt++;
        }
        return cnt;
    }
}