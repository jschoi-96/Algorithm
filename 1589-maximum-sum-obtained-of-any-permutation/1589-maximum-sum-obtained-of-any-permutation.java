class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int [] freq = new int[n];

        for(int [] req: requests) {
            int st = req[0];
            int en = req[1];
            freq[st]++;

            if (en+1 < n)
                freq[en+1]--;
        }

        // freq 빈도수를 저장 
        for(int i = 1; i < n; i++) {
            freq[i] += freq[i-1];
        }

        Arrays.sort(nums);
        Arrays.sort(freq);

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += (nums[i] * (long) freq[i]);
            //System.out.println(freq[i]);
            sum %= 1000000007;
        }
        return (int) sum;
    }
}