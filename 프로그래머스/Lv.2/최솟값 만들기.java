import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // max랑 min을 각각 찾아서 곱하기?
        Arrays.sort(A); // 1 2 4
        Arrays.sort(B); // 4 5 5
        int idx = A.length - 1;
        for(int i = 0; i < A.length; i++){
            
            answer += A[i] * B[idx--];
        }

        return answer;
    }
}
