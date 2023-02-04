class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ab", "b"));
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {  //要求子串长度太大
            return "";
        }
        int[] count = new int[58];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'A']++;
            count[s.charAt(i) - 'A']--;
        }
        if (Isanswer(count)) {    //s的第一个已经符合条件，一定是一个最小子串
            return s.substring(0, t.length());
        }
        int j = t.length() - 1;
        int i = 0;
        String answer = s;
        boolean flag = false;
        while (i < s.length() - t.length() + 1) {
            if (Isanswer(count)) {//符合条件时移动左指针找更小的答案
                answer = answer.length() > j - i + 1 ? s.substring(i, j + 1) : answer;
                flag = true;
                count[s.charAt(i++) - 'A']++;
            } else if (j < s.length() - 1) {//否则移动右指针找符合条件的答案
                count[s.charAt(++j) - 'A']--;
            } else {
                break;
            }
        }
        return flag ? answer : "";
    }

    public boolean Isanswer(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                return false;
            }
        }
        return true;
    }
}