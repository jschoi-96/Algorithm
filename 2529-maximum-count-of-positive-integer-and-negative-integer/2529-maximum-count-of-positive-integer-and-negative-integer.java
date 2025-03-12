class Solution {
    public int maximumCount(int[] nums) {
        int min_cnt = binarySearch(nums, 0);
        int max_cnt = nums.length - binarySearch(nums, 1);
        System.out.println(min_cnt + " " + max_cnt);
        return Math.max(min_cnt, max_cnt);
    }

    public int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}