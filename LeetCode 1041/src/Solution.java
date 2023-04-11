import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isRobotBounded("GGLLGG"));
    }

    public boolean isRobotBounded(String instructions) {
        int len = instructions.length();
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            if (len % i == 0) {
                arr.add(i);
            }
        }

        StringBuilder sb = new StringBuilder(instructions);
        String minrepeat = "";

        for (Integer k : arr) {
            String item = sb.substring(0, k);
            boolean flag = true;
            for (int i = 1; i < len / k; i++) {
                if (!item.equals(sb.substring(i * k, i * k + k))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                minrepeat = item;
                break;
            }
        }

        int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int[] place = {0, 0};
        int face = 0;
        for (int i = 0; i < 4; i++) {
            for (char c : minrepeat.toCharArray()) {
                switch (c) {
                    case 'G':
                        place[0] += direction[face][0];
                        place[1] += direction[face][1];
                        break;
                    case 'L':
                        face = (face - 1 + 4) % 4;
                        break;
                    case 'R':
                        face = (face + 1 + 4) % 4;
                        break;
                }
            }
            if (place[0] == 0 & place[1] == 0) {
                return true;
            }
        }


        return false;
    }
}