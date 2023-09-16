import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.garbageCollection(new String[]{"MMG","PPPMGPG","GGMMG"},new int[]{4,3}));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int[] last = new int[]{0, 0, 0};
        int answer = 0;
        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            answer += s.length();
            if (s.contains("M")) {
                last[0] = i;
            }
            if (s.contains("P")) {
                last[1] = i;
            }
            if (s.contains("G")) {
                last[2] = i;
            }
        }
        int one = Arrays.stream(last).min().getAsInt();
        int three = travel.length;
        int two = 0;
        if (last[0] == one && last[1] == three) two = last[2];
        if (last[0] == one && last[2] == three) two = last[1];
        if (last[1] == one && last[2] == three) two = last[0];
        if (last[1] == one && last[0] == three) two = last[2];
        if (last[2] == one && last[1] == three) two = last[0];
        if (last[2] == one && last[0] == three) two = last[1];
        for (int i = 0; i < one; i++) {
            answer += travel[i] * 3;
        }
        for (int i = one; i < two; i++) {
            answer += travel[i] * 2;
        }
        for (int i = two; i < three; i++) {
            answer += travel[i];
        }
        return answer;
    }
}