import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> answer = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);

            if (low <= high) {
                answer.add(new int[]{low, high});
            }

            if(firstList[i][1]>secondList[j][1])
                j++;
            else
                i++;
        }

        return answer.toArray(new int[answer.size()][2]);
    }
}