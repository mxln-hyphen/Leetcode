import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        Solution solution = new Solution();
        System.out.println(solution.isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('#', -1);

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }


        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];
            int len = str1.length() > str2.length() ? str1.length() : str2.length();
            int j = 0;
            while (j < len) {
                int firstorder = map.get(str1.length() > j ? str1.charAt(j) : '#');
                int secondorder = map.get(str2.length() > j ? str2.charAt(j) : '#');

                if (firstorder > secondorder) {
                    return false;
                } else if (firstorder == secondorder) {
                    j++;
                } else {
                    break;
                }
            }
        }
        return true;
    }
}