import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int numb=Integer.parseInt(stack.pop());
                    int numa=Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(cumnum(numa,numb,token)));
                    break;
                default:
                    stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    int cumnum(int a,int b,String ch){
        switch (ch){
            case "+":return a+b;
            case "-":return a-b;
            case "*":return a*b;
            case "/":return a/b;
        }
        return 0;
    }
}