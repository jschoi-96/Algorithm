class Solution {
    // 더하기, 빼기를 사용하여 타겟 넘버를 만들기. 총 갯수는 numbers 길이
    // 시간복잡도: 2 * 50 ㅇㅋ
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    private void dfs(int [] numbers, int target, int sum, int depth) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, sum + numbers[depth], depth + 1);
        dfs(numbers, target, sum - numbers[depth], depth + 1);
        
    }
}