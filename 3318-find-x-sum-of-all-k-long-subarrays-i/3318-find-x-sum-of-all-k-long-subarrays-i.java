class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int [] res = new int[n - k + 1];
        
        for(int i = 0; i < n - k + 1; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = i; j < k + i; j++) {    
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }

            List<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys, (a,b) -> {
                if (map.get(a) == map.get(b)) {
                    return b - a;
                }
                return map.get(b) - map.get(a);
            });

            for(int j = 0; j < x; j++) {
                int target = keys.get(j);
                res[i] += (target * map.get(target)); 
            }
        }
        

        return res;
    }
}