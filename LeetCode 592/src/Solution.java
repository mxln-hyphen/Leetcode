import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fractionAddition("1/3-1/2"));
    }

    public String fractionAddition(String expression) {
        List<Integer> molecular = new ArrayList<>();    //分子
        List<Integer> denominator = new ArrayList<>();  //分母
        List<Boolean> symbol = new ArrayList<>();       //符号，true代表+，false代表-
        int finalDenominator = 1;
        int finalMolecular = 0;
        boolean finalSymbol = true;
        StringBuffer s = new StringBuffer(expression);
        if (s.charAt(0) != '-') {
            s.insert(0, '+');
        }
        int i = 0;
        //统计
        while (i < s.length()) {
            symbol.add(s.charAt(i) == '+');
            i++;
            molecular.add(s.charAt(i + 1) == '/' ? Integer.parseInt(s.substring(i, i + 1)) : 10);
            i += molecular.get(molecular.size() - 1) == 10 ? 3 : 2;
            denominator.add(i + 1 == s.length() || s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-'
                    ? Integer.parseInt(s.substring(i, i + 1)) : 10);
            i += denominator.get(molecular.size() - 1) == 10 ? 2 : 1;
            //计算最后的分母
            finalDenominator *= denominator.get(molecular.size() - 1);
        }
        //计算
        i = 0;
        for (Boolean aBoolean : symbol) {
            if (aBoolean) {
                finalMolecular += finalDenominator / denominator.get(i) * molecular.get(i);
            } else {
                finalMolecular -= finalDenominator / denominator.get(i) * molecular.get(i);
            }
            i++;
        }
        int finalGcd = gcd(finalDenominator, finalMolecular);
        finalGcd = finalGcd > 0 ? finalGcd : -finalGcd;
        finalDenominator /= finalGcd;
        finalMolecular /= finalGcd;
        String answer = finalMolecular >= 0 ? "" : "-";
        finalMolecular = finalMolecular >= 0 ? finalMolecular : -finalMolecular;
        answer += Integer.toString(finalMolecular) + "/" + Integer.toString(finalDenominator);
        return answer;
    }


    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}