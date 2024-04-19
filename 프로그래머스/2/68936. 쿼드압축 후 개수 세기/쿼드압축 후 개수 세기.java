class Solution {
    static int [] answer = new int[2];
    public int[] solution(int[][] arr) {
        int len = arr.length;
        
        compact(arr, 0, 0, len);
        return answer;
    }
    
    private void compact(int [][] arr, int x, int y, int size) {
        if (check(arr, x, y, size)) { // 압축했을 때 해당 값이 모두 동일하다면, answer 배열 값을 증가시켜준다.
            answer[arr[x][y]]++;
            return; 
        }
        int newSize = size / 2;
        compact(arr, x, y, newSize);  // 좌상단
        compact(arr, x, y + newSize, newSize);  // 우상단
        compact(arr, x + newSize, y, newSize);  // 좌하단
        compact(arr, x + newSize, y + newSize, newSize);  // 우하단
    }
    
    private boolean check(int [][] arr, int x, int y, int size) {
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}