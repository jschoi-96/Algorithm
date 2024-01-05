풀이 방법
1. 해쉬맵을 사용하여 해당 문자열과 인덱스 값을 저장해주었다.
2. 루프를 돌면서, val_ext보다 작은 경우를 2차원 배열에 저장해주었다.
3. 정렬 기준을 sort_by에 맞춰서 정렬해주었다.

이 문제를 풀면서 배운 것은, Comparator 인터페이스에 대해서 더 공부해야겠다. 
처음에 sort_by 기준으로 어떻게 정렬해야 할지 몰라서 인터넷을 검색했었다.
Arrays.sort(arr, (o1,o2) -> arr[o1] - arr[o2]) 이런식으로 오름차순을 할 수 있다.
Arrays.sort(arr, Comparator.comparingInt(arr -> arr[idx]) 이런식으로도 comparingInt 메서드를 통해서도 정렬이 가능하다. Comparator 인터페이스의 메서드로는,
Int, Long, Double을 비교할 수 있고 내림차순으로 변경해주는 .reversed() 메서드도 있다.

그리고, 스트림을 사용하자! 내 10줄이 넘어가는 코드를 다른 사람의 코드에서 확인할 수 있듯이 한줄로 요약했다.

import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // ext, sort_by는 4가지 값중 하나
        // 해쉬맵을 사용해서 인덱스도 저장해야하나? 
        String [] temp = {"code", "date", "maximum", "remain"};
        Map<String, Integer> map = new HashMap<>();
        map.put("code" , 0); map.put("date", 1);
        map.put("maximum", 2); map.put("remain", 3);
        
        int idx = map.get(ext); // 해당 ext에 맞는 인덱스
        int count = 0;
        for(int i = 0; i < data.length; i++){
            if (data[i][idx] < val_ext) {
                count++;
            }
        }
        int [][] answer = new int[count][4];
        int new_idx = 0;
        
        for(int i = 0; i < data.length; i++){
            if (data[i][idx] < val_ext) {
                for(int j = 0; j < 4; j++){
                    answer[new_idx][j] = data[i][j];
                }
                new_idx++; // 인덱스 값 업데이트 
            }
        }
        
        int sort_idx = map.get(sort_by);
        //Arrays.sort(answer, Comparator.comparingInt(arr -> arr[sort_idx]));
        Arrays.sort(answer, (a, b) -> a[sort_idx] - b[sort_idx]);
        return answer;
    }
}

다른 사람의 풀이
import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> colOrder = new HashMap<>();
        colOrder.put("code", 0);
        colOrder.put("date", 1);
        colOrder.put("maximum", 2);
        colOrder.put("remain", 3);
        
        int[][] filteredData = Arrays.stream(data).filter(x -> x[colOrder.get(ext)] < val_ext).toArray(int[][]::new);
        Arrays.sort(filteredData, (o1, o2) ->  o1[colOrder.get(sort_by)] - o2[colOrder.get(sort_by)]);

        return filteredData;
    }
}

