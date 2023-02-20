import javax.swing.text.StyledEditorKit;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int[] asteroids = {10, 2, -5};
        Solution solution = new Solution();
        for (int i : solution.asteroidCollision(asteroids)) {
            System.out.println(i);
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                boolean broeken=false;
                while (!stack.empty()&&stack.peek()>=0) {
                    if (-asteroid > stack.peek()) {
                        stack.pop();
                    } else if (-asteroid == stack.peek()) {
                        stack.pop();
                        broeken=true;
                        break;
                    } else {
                        broeken=true;
                        break;
                    }
                }
                if(!broeken){
                    stack.push(asteroid);
                }

            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}