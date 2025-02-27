class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length; 

        int maxSum = 0, minSum = 0;
        int maxPrefix = 0, minPrefix = 0;

        for(int i = 0; i < n; i++) {
            maxPrefix = Math.max(maxPrefix + nums[i], 0);
            minPrefix = Math.min(minPrefix + nums[i], 0);

            // System.out.println(minPrefix + " " + maxPrefix);
            maxSum = Math.max(maxSum, maxPrefix);
            minSum = Math.max(minSum, Math.abs(minPrefix));
        }
        return Math.max(maxSum, minSum);
    }
}