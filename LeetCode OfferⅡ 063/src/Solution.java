import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<String> dictionary;

        Solution solution = new Solution();
        System.out.println(solution.replaceWords);
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String ret = "";
        String[] words = sentence.split(" ");
        for (String word : words) {
            ret+=trie.searchPrefix(word)+" ";
        }
        return ret.substring(0,ret.length()-1);
    }
}