
Sol 1) Brute Force O(N^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}

Sol2) HashMap O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }

            map.put(nums[i] , i);
        }
        return new int [] {};
    }
}

처음에 해쉬 테이블로 푸는 방법이 떠오르지 않아서 brute force로 해결하였다.

1. int 배열을 순회하며 숫자와 인덱스를 저장해준다.
2. 똑같이 순회하며 containsKey 메서드를 사용하여 타겟에서 맵에 저장된 key값을 뺀 값이 있는지 체크한다.
3. 있다면, 두 인덱스를 반환해준다.

시간 차이: 47ms vs 2ms로 많은 차이가 났다.
