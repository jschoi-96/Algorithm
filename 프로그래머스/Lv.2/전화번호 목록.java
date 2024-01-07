풀이 방법
1. 먼저 배열을 sorting 해준다. 
  배열을 sorting 해주는 이유는, 더 짧은 접두어들이 앞에 나오기 때문에 시간 복잡도가 줄어든다 -> O(n^2) -> O(nlogn) 
2. contains 메서드로 문자열을 포함하는지 체크하고, indexOf 메서드로 접두어인지 체크해준다.

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++){
            if (phone_book[i+1].contains(phone_book[i]) && phone_book[i+1].indexOf(phone_book[i]) == 0){
                return false;
            }
        }
        return answer;
    }
}

해쉬를 사용한 풀이 방법
1. 처음에 key, value 형태로 저장을 해준다.
2. phone_book 원소들을 순회하면서, substring으로 원소들을 0부터 n-1까지 쪼개면서 동일한 key가 있는지 확인한다.
3. 동일한 key가 있다는 것은 접두사가 있다는 것이므로 false 리턴해준다.

문제에서 실수했던 부분은 substring을 0부터 j까지 하는데 자기 자신을 포함하는게 아닌가? 생각했다. 

자기 자신을 포함하고 싶다면 substring(0,j+1)로 해줘야한다!! 항상 substring 범위에서 좀 헷갈리는것 같다. 

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], i);
        }
        
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++){
                if (map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        return answer;
    }
}
