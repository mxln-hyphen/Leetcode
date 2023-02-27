import java.util.Map;

class Solution {
    int answer = 0;

    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        Solution solution = new Solution();
        System.out.println(solution.minimumLengthEncoding(words));
    }

    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            StringBuilder sbuilder = new StringBuilder();
            sbuilder.append(word);
            trie.insert(sbuilder.reverse().toString());
        }

        dfs(trie, 0);

        return answer;
    }

    public void dfs(Trie node, int count) {
        if (!node.children.isEmpty()) {
            for (Map.Entry<Character, Trie> entry : node.children.entrySet()) {
                dfs(entry.getValue(), count + 1);
            }
        } else {
            answer += count + 1;
        }
    }
}