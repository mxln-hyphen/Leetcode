import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        List<String> timePoints = List.of(new String[]{"23:59", "00:00"});

        Solution solution = new Solution();
        System.out.println(solution.findMinDifference(timePoints));
    }

    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size()>60*24){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int answer = Integer.MAX_VALUE;
        int earlytime = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            String[] strs = timePoints.get(i).split(":");
            int time = Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
            if(map.containsKey(time)){
                return 0;
            }
            map.put(time, 0);
            earlytime = time < earlytime ? time : earlytime;
        }
        int item = earlytime;
        for (int i = earlytime+1; i < 24 * 60; i++) {
            if (map.containsKey(i)) {
                answer = answer > (i - item) ? i - item : answer;
                item = i;
            }
        }
        answer = answer > (earlytime + 60 * 24 - item) ? (earlytime + 60 * 24 - item) : answer;
        return  answer;
    }
}