class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        int pairs = n/2;

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 2) {
                cnt++;
                map.put(nums[i], 0);
            }
        }
        return cnt == pairs;
    }
}