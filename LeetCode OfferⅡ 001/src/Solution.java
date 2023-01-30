class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(-2147483648, -2147483648));
    }

    public int divide(int a, int b) {
        if (a == 0x80000000 & b == -1) {
            return 0x7FFFFFFF;
        }
        if (a == 0x80000000 & b == 0x80000000) {
            return 1;
        }
        boolean flag = true;
        if (((a>>>31) ^ (b>>>31)) == 1) {//运算结果为负数
            flag = false;
        }
        int answer = 0;
        if((a>>>31)==0){
            a = -a;
        }
        if((b>>>31)==0){
            b = -b;
        }
        while (a <= b) {
            int subnum = b;
            int k = 1;
            while (a - subnum - subnum < 0) {
                subnum += subnum;
                k += k;
            }
            a -= subnum;
            answer += k;
        }
        if (!flag) {
            answer = -answer;
        }
        return answer;
    }
}