import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(39));
    }

    public int minOperations(int n) {
        int answer = 0;
        int bin = n;
        int k = 0;//位数
        while (n != 0) {
            if ((n >> k) % 2 == 1 && (n >> k + 1) % 2 == 1) {
                answer += 1;
                n += 1 << k;
            } else if ((n >> k) % 2 == 1 && (n >> k + 1) % 2 == 0) {
                answer += 1;
                n -= 1 << k;
            }
            k++;
        }

        return answer;
    }
}