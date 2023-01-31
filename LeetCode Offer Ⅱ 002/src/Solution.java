class Solution {
    public String addBinary(String a, String b) {
        String answer = "";
        int lena = a.length();
        int lenb = b.length();
        //翻转a，b
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int k = 0;
        for (int i = 0; i < (lena < lenb ? lena : lenb); i++) {
            int m = (int) a.charAt(i);
            int n = (int) b.charAt(i);
            k = (m + n + k) >> 1;
            answer.concat(String.valueOf((m + n + k) & 1));
        }
        if(lena>lenb){

        }

    }
}