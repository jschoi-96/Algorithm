class Solution {
    // length -> 10만 
    // l부터 r까지 val만큼을 빼고, 또 어떻게 nums가 다 0인지 판단할것인가?

    // -1 0 0 1
    // -2 0 0 2
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = queries.length;
        int lo = 1, hi = n;

        if (isAllZero(nums)) return 0;

        if (!bst(hi, nums, queries)) return -1;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (bst(mid, nums, queries)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public boolean bst(int k, int[] nums, int[][] queries) {
        int n = nums.length;
        int [] prefix = new int[n + 1];

        for(int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            prefix[l] += val;
            prefix[r + 1] -= val;
        }

        int check = 0;
        for(int i = 0; i < n; i++) {
            check += prefix[i];
            if (check < nums[i]) return false;
            // 0이 되지 않았기 때문에 false 리턴
        }
        return true;
    }

    public boolean isAllZero(int[] nums) {
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        if (total == 0) return true;
        return false;
    }
}