class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length; 

        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < n-2; i++) {
            int lo = i + 1;
            int hi = n - 1;
            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];

                if (Math.abs(target - closest) > Math.abs(target - sum)) {
                    closest = sum;
                }

                // System.out.println(sum);

                if (sum < target) lo++;
                else if (sum > target) hi--;
                else return sum;
            }
        }
        
        return closest;
    }
}