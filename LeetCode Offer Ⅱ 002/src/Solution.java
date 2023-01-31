class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "1";
        String b = "111";
        System.out.println(solution.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        String answer = "";
        int lena = a.length();
        int lenb = b.length();
        //翻转a，b
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int k = 0;
        int i = 0;
        for (i = 0; i < (lena < lenb ? lena : lenb); i++) {
            int m = (int) a.charAt(i) - 48;
            int n = (int) b.charAt(i) - 48;
            answer += String.valueOf(m ^ n ^ k);
            k = (m + n + k) >> 1;
        }
        String item="";
        if(lena!=lenb){
            item = lena > lenb ? a.substring(i) : b.substring(i);
        }
        else{
            item = "0";
        }
        for (int j=i ; j < (lena < lenb ? lenb : lena); j++) {
            int m = (int) item.charAt(j-i) - 48;
            answer += String.valueOf(m ^ k);
            k = (m + k) >> 1;
        }
        if(k!=0)
            answer+=String.valueOf(k);
        answer = new StringBuilder(answer).reverse().toString();
        return answer;
    }
}