class Solution {
    // nums길이 -> 10만
    // element * 등장 수가 > 길이 
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int num = nums.get(i);
            map1.put(num, map1.getOrDefault(num, 0) + 1); // 왼쪽
            map.put(num, map.get(num) - 1); // 오른쪽

            int left = map1.get(num), right = map.get(num);
            if (left * 2 > i + 1 && right * 2 > n - i - 1) {
               return i;
            }
            //System.out.println("left: " + left + " right: " + right + " i: " + i);
        }   
        return -1;
    }
}