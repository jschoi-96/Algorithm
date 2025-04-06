class Solution {
    /*
        S,D,T는 각각 1,2,3제곱 / 
        * -> 해당 점수와 바로 이전의 점수를 2배
        # -> 해당 점수를 마이너스 처리
        
        *는 첫번째에도 나올 수 있기 때문에 인덱스 주의할것
        1. String을 순회하며 해당 숫자의 인덱스를 파악 (이 때, 10엣지 처리)
        1-1. 숫자들만의 인덱스를 따로 체크
        2. 문자열이 있을 때, 앞에 있던 숫자들에 대한 계산을 해줘야함.
        3. S,D,T,#에 대해서 계산을 해주는 메서드를 생성. 
        4. *에 대해서 계산하는 메서드를 생성(*은 이전 인덱스도 알아야하기 때문에 따로 생성)
    */
    public int solution(String dartResult) {
        int answer = 0;
        
        int idx = 0;
        int numIdx = 0;
        int prev = 0; // 이전 값을 저장
        
        int [] arr = new int[dartResult.length()];
        // 임의로 길이 설정
        
        for(char c : dartResult.toCharArray()) {
            int check = c - '0';
            if (check >= 0 && check <= 9) {
                // 10 엣지 처리
                if (check == 0 && (idx > 0 && dartResult.charAt(idx - 1) == '1')) prev = 10;
                else prev = check;
                numIdx++; // 숫자 인덱스 +1
            }   
            
            else { // 여기서
                if (c == '*') {
                    if (numIdx > 0) {
                        arr[numIdx - 1] *= 2;
                    }
                    arr[numIdx] *= 2;
                }
                
                else {
                    int cur = notStar(prev, c);
                    prev = cur;
                    arr[numIdx] = prev;
                }
            }
            
            // for(int i = 0; i < arr.length; i++) {
            //     if (arr[i] != 0) System.out.print(arr[i] + " ");
            // }
            // System.out.println();
            idx++;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) answer += arr[i];
        }
        return answer;
    }
    
    public int notStar(int prev, char c) {
        if (c == 'S') return prev;
        else if (c == 'D') return prev*prev;
        else if (c == 'T') return prev*prev*prev;
        else if (c == '#') return prev*-1;
        return 0;
    }
}