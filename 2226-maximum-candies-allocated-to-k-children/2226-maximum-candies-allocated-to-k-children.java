class Solution {
    // 각 캔디의 값을 두개로 나눌 수 있다. 그래서 총 캔디의 갯수를 
    // k명의 애들한테 줬을 때의 캔디 값의 최댓값을 구하라
    // 10만 -> O(nlogn) 이하
    
    // [5,8,6], k = 4
    // [5,4,4,4,2]
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);

        int n = candies.length;
        int lo = 1, hi = 10000000;
        // 5 + 8 / 2 = 6
        // 5 + 6 / 2

        if (k == 1) return candies[n-1];

        boolean flag = false;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long check = 0;
            for(int i = 0; i < n; i++) {
                if (candies[i] < mid) { // 만약에 현재 값보다 크다면, 줄수 없음
                    //hi = mid - 1;
                    //System.out.println(hi);
                }

                else { // candies[i] >= mid
                    check += candies[i] / mid;
                }
            }

            // System.out.println(lo + " " + hi + " " + check);
            if (check < k) hi = mid;
            else {
                flag = true;
                lo = mid + 1;
                // System.out.println("lo: " + lo);
            }
        }

        if (!flag) return 0;
        return lo - 1;
    }
}