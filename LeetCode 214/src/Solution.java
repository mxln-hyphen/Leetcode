class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.methodname);
    }

    public String shortestPalindrome(String s) {
        int len = s.length();
        int start = len % 2 == 0 ? len / 2 - 1 : len / 2;
        char[] str = s.toCharArray();
        String answer;
        for (int i = start; i >= 0; i--) {
            if(isoddPalindrome(i,str)) {
                continue;
            }
            else {

            }
        }
    }

    public boolean isoddPalindrome(int mid, char[] str) {
        int i = mid - 1;
        int j = mid + 1;
        while (i >= 0) {
            if (str[i] != str[j])
                return false;
            i--;
            j++;
        }
        return true;
    }

    public boolean isevenPalindrome(int mid, char[] str) {
        int i = mid;
        int j = mid + 1;
        while (i >= 0 && j < str.length) {
            if (str[i] != str[j])
                return false;
            i--;
            j++;
        }
        return true;
    }

    public String fillPalinDrome(){

    }


}