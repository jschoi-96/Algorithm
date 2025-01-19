class Solution {
    public int maximumCount(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] > 0 || nums[nums.length - 1] < 0) return nums.length;

        int lo = 0, hi = nums.length - 1;

        int min = 0, max = 0;
        while(nums[lo] < 0) {
            lo++;
        }

        while(nums[hi] > 0) {
            hi--;
            max++;
        }

        //System.out.println(lo + " " + max);
        return Math.max(lo, max);
    }
}