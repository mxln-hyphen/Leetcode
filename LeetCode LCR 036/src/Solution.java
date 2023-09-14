import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            int i;
            switch (token) {
                case "+":
                    deque.push(deque.pop() + deque.pop());
                    break;
                case "-":
                    i = deque.pop();
                    deque.push(deque.pop() - i);
                    break;
                case "*":
                    deque.push(deque.pop() * deque.pop());
                    break;
                case "/":
                    i = deque.pop();
                    deque.push(deque.pop() / i);
                    break;
                default:
                    deque.push(Integer.parseInt(token));
            }
        }
        return deque.peek();
    }

}