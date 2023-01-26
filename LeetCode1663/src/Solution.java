class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSmallestString(91146, 181802));
    }

    public String getSmallestString(int n, int k) {
        String answer = "";
        int znum = k / 26;
        n = n - znum;
        k = k % 26;
        int anum = 0;
        while (n > k) {
            k += 26;
            n += 1;
            znum -= 1;
        }
        anum += n - 1;
        k -= n - 1;
        if(anum>0){
            answer+="a".repeat(anum);
        }
        if (k != 0 & n != 0) {
            String ch = "" + (char) (k + 96);
            answer += ch;
        }
        if(znum>0) {
            answer += "z".repeat(znum);
        }
        return answer;
    }
}