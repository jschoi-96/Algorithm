class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (n == 2 && nums[0] == nums[1]) return true;
        for(int i = k; i < n; i++) {
            if (nums[i-k] == nums[i]) return true;
        }
        return false;
    }
}