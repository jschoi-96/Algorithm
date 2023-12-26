풀이방법
1. 각 알파벳의 등장횟수를 저장
2. int 배열을 사용하여 저장했지만 Map을 사용해서 풀이도 가능

class Solution {
    public boolean isAnagram(String s, String t) {
        int [] sArr = new int[26];
        int [] tArr = new int[26];

        for(int i = 0; i < s.length(); i++){
            sArr[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            tArr[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < sArr.length; i++){
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }
}
