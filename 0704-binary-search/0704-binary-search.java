class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        int lo = 0, hi = n - 1;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] < target) lo++;
            else if (nums[mid] > target) hi--;
            else return mid;
        }
        return -1;
    }
}