import java.util.*;
class Solution {
    // 1. 장르에 해당하는 플레이 타임을 맵에 넣는다. 
    // 2. 플레이 타임이 더 많은 장르를 우선적으로 저장해야 한다.
    // 2-1. 같은 장르 중에서 더 많이 재생된 노래를 우선적으로 저장
    // 2-2. 재생 횟수가 같다면 고유 번호로 비교
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            indexMap.put(i, plays[i]);
        }
        
        
        // map을 내림차순해서 재생횟수가 많은 순서대로 정렬 (pop, classic)
        List<String> keys = new ArrayList<>(genreMap.keySet());
        Collections.sort(keys, (a,b) -> genreMap.get(b) - genreMap.get(a));
     
        // 고유 번호를 재생 횟수가 많은 순서대로 정렬
        // [4, 2500], [3, 800] ... 
        List<Integer> indexList = new ArrayList<>(indexMap.keySet());
        Collections.sort(indexList, (a,b) -> indexMap.get(b) - indexMap.get(a)); 
        for (String key : keys) {
            int size = 0;
            for(Integer index : indexList) {
                if (genres[index].equals(key) && size < 2) {
                    size++;
                    answer.add(index);
                }
            }
        }
        
        int [] res = new int[answer.size()];
        for(int i = 0; i < res.length; i++) res[i] = answer.get(i);
        return res;
    }
}