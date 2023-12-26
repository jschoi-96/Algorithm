문제 접근 방식
HashMap을 사용하여 map의 value 기준으로 내림차순을 처음에 해주었으나, 그렇게 했을 때 그에 해당하는 key 값을 찾기가 힘들었다.

* Collections.sort(tmp, Collections.reverseOrder())로 단순히 sort해줬을 때 문제 발생.

tmp 리스트에 맵의 key값들을 넣어주고, tmp.sort((a,b) -> map.get(b) - map.get(a))를 통해서 빈도수를 내림차순 해주었다.

map[1] = 3, map[2] = 2, map[3] = 1
tmp = {1,2,3} after sort -> 빈도 높은 순서대로

풀이 방법
1. 해쉬 맵을 선언해서 해당 숫자와 빈도 수를 저장한다.
2. 해쉬맵의 key인 해당 숫자를 가지고 있는 리스트를 선언해준다.
3. 리스트를 sort하는데, 이 때 빈도 수를 기준으로 내림차순 해준다.
4. k까지 돌면서, res배열에 숫자를 저장한다.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> tmp = new ArrayList<>(map.keySet());
        tmp.sort((a,b) -> map.get(b) - map.get(a));
        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}
