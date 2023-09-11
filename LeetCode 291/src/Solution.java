import javax.swing.text.StringContent;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        String pattern = "d";
        String s = "e";
        Solution solution = new Solution();
        System.out.println(solution.wordPatternMatch(pattern, s));
    }

    HashMap<Character, String> map;
    StringBuffer stringBuffer;
    String p;
    int p_len;
    int s_len;
    boolean answer = false;


    public boolean wordPatternMatch(String pattern, String s) {
        map = new HashMap<>();
        stringBuffer = new StringBuffer(s);
        p_len = pattern.length();
        s_len = s.length();
        p = pattern;
        dfs(0, 0);
        if (answer) {
            return true;
        }
        return false;
    }

    boolean dfs(int idx_s, int idx_p) {
        if (idx_p == p_len) {
            if(idx_s==s_len) {
                answer = true;
            }
            return true;
        }
        if (map.containsKey(p.charAt(idx_p))) {
            String str = map.get(p.charAt(idx_p));
            if (s_len - idx_s < str.length() || !str.equals(stringBuffer.substring(idx_s, idx_s + str.length()).toString())) {
                return false;
            } else {
                dfs(idx_s + str.length(), idx_p + 1);
            }
        } else {
            for (int i = idx_s; i < s_len - (p_len - idx_p)+1; i++) {
                if(!map.containsValue(stringBuffer.substring(idx_s, i + 1).toString())) {
                    map.put(p.charAt(idx_p), stringBuffer.substring(idx_s, i + 1).toString());
                    dfs(i + 1, idx_p + 1);
                    map.remove(p.charAt(idx_p));
                }
            }
        }
        return false;
    }
}