import java.util.*;
class Solution {
    // 1. expression을 숫자, 연산으로 분리
    // 2. 백트래킹을 돌리는데, 연산 우선순위를 정합
    // 3. 합은 long타입으로 받기
    
    static char[] op = {'+', '-', '*'};
    static char[] order = new char[3]; //순서를 저장하는 배열
    static boolean[] visited = new boolean[3];
    
    static List<Long> arr = new ArrayList<>();
    static List<Character> opList = new ArrayList<>();
    static long answer = 0;
    public long solution(String expression) {
        
        String tmp = "";
        for(char c : expression.toCharArray()) {
            if (!Character.isDigit(c)) {
                arr.add(Long.parseLong(tmp));
                tmp = "";
                opList.add(c);
            }
            else tmp += c;
        }
        
        arr.add(Long.parseLong(tmp));
        
        dfs(0);
        
        return answer;
    }
    
    public void dfs(int depth) {
        if (depth == op.length) {
            calc();
            
            // for(int i = 0; i < 3; i++) {
            //     System.out.print(order[i] + " ");
            // }
            // System.out.println();
            return;
        }
        
        for(int i = 0; i < op.length; i++) {
            if (!visited[i]) {
                order[depth] = op[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public void calc() {
        List<Long> copyArr = new ArrayList<>();
        List<Character> copyOp = new ArrayList<>();
        copyArr.addAll(arr);
        copyOp.addAll(opList);
        
        for(int i = 0; i < order.length; i++) {
            char cur = order[i];
            
            for(int j = 0; j < copyOp.size(); j++) {
                if (copyOp.get(j) == cur) {
                    long res = calOp(cur, copyArr.get(j), copyArr.get(j+1));
                    
                    // 이전 값 리스트에서 삭제
                    copyArr.remove(j+1);
                    copyArr.remove(j);
                    copyOp.remove(j);
                    
                    copyArr.add(j, res);
                    
                    j--; // 2개를 제거했으니 인덱스도 하나 제거해야함  
                }
            }
        }
        
        answer = Math.max(Math.abs(copyArr.get(0)), answer);
        //System.out.println(copyArr.get(0));
    }
    
    public long calOp(char cur, long n1, long n2) {
        if (cur == '*') return n1 * n2;
        else if (cur == '+') return n1 + n2;
        else if (cur == '-') return n1 - n2;
        return 0;
    }
}