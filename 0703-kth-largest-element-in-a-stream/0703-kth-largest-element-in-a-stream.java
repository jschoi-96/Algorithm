class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) { // k번째로 크다는 것은 밑에서부터 size - k 체크 
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */