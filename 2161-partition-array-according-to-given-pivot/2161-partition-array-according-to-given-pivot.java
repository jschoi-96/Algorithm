class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = nums.length;

        int pivot_cnt = 0;
        for(int i = 0; i < n; i++) {
            if (nums[i] < pivot) q1.add(nums[i]);
            else if (nums[i] > pivot) q2.add(nums[i]);
            else pivot_cnt++;
        }

        int [] res = new int[n];
        int idx = 0;
        while(!q1.isEmpty()) {
            res[idx++] = q1.poll();
        }

        for(int i = 0; i < pivot_cnt; i++) res[idx++] = pivot;

        while(!q2.isEmpty()) {
            res[idx++] = q2.poll();
        }
        return res;
    }
}