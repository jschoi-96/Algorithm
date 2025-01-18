class Solution {
    // 0으로 나누는 경우 조심

    int res = 0;
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        
        for(String token : tokens) {

            if (isOperator(token) && !s.isEmpty()) {
                int num2 = Integer.parseInt(s.pop());
                int num1 = Integer.parseInt(s.pop());

                int newNum = 0;
                if (token.equals("+")) newNum = num1 + num2;
                else if (token.equals("-")) newNum = num1 - num2;
                else if (token.equals("*")) newNum = num1 * num2;
                else {
                    if (num2 == 0) newNum = 0;
                    else newNum = num1 / num2;
                }

                // System.out.println(newNum);
                res = newNum;
                s.add(String.valueOf(newNum));
            }
            else s.add(token);
        }
        return res;
    }

    public boolean isOperator(String target) {
        return target.equals("+") || target.equals("-") ||
        target.equals("*") || target.equals("/");
    }
}