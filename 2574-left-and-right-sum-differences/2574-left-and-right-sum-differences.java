class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int [] left = new int[n];

        int total = nums[0];
        for(int i = 1; i < n; i++) {
            left[i] = left[i-1] + nums[i-1];
            System.out.print(left[i] + " ");
            total += nums[i];
        }

        int [] right = new int[n];
        for(int i = 0; i < n - 1; i++) {
            right[i] = total - nums[i];
            total -= nums[i];
        }

        int [] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = Math.abs(left[i] - right[i]);
        }
        return res;
    }
}