class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int i = 0;
        int j = 0;
        int[] count = new int[128];
        int answer = 0;
        int item;
        boolean flag = false;
        ++count[s.charAt(j)];
        answer = Math.max(j - i + 1, answer);
        while (i < s.length()) {
            if (!flag&&j<s.length()-1) {//移动指针j
                item = ++count[s.charAt(++j)];
                flag = item == 2;
            } else {//移动指针i
                item = --count[s.charAt(i++)];
                flag = item != 1;
            }
            if (!flag) {
                answer = Math.max(j - i + 1, answer);
            }
        }
        return answer;
    }
}