class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, current_count = 1, result = 0;

        int[] circles = new int[n * 2];
        for (int i = 0; i < n; i++) {
            circles[i] = colors[i];
            circles[i + n] = colors[i];  
        }

        for (int i = 0; i < n + k - 2; ++i) {
            if (circles[i] != circles[i + 1]) {
                current_count++;
            } else {
                current_count = 1;
            }

            if (current_count >= k) result += 1;
        }

        return result;
    }
}