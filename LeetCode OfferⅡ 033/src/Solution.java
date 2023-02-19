import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] strs = {""};

        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();
        int k = 0;

        for (int i = 0; i < strs.length; i++) {
            String item = strrank(strs[i]);
            if (map.containsKey(item)) {//如果存在变位词
                answer.get(map.get(item)).add(strs[i]);
            } else {//如果不存在变位词（第一次出现）
                map.put(item, k);
                List<String> newword = new ArrayList<String>();
                newword.add(strs[i]);
                answer.add(k++, newword);
            }
        }
        return answer;
    }

    String strrank(String str) {
        int[] charnum = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charnum[(int) str.charAt(i) - (int) 'a']++;
        }
        String ret = "";
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < charnum[i]; j++) {
                 ret += (char) (i + (int) 'a');
            }

        }
        return ret;
    }
}