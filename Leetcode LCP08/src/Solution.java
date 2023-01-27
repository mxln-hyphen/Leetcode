class Solution {
    public static void main(String[] args) {
        int[][] increase = {{1, 1, 1}};
        int[][] requirements = {{0, 0, 0}};
        Solution solution = new Solution();
        solution.getTriggerTime(increase, requirements);

    }

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] answer = new int[requirements.length];

        for (int i = 1; i < increase.length; i++) {
            for (int j = 0; j < 3; j++) {
                increase[i][j] += increase[i - 1][j];
            }
        }

        for (int i = 0; i < requirements.length; i++) {
            if(requirements[i][0]==0&requirements[i][1]==0&requirements[i][2]==0){
                answer[i]=0;
                continue;
            }
            if (!compare(increase[increase.length - 1], requirements[i])) {
                answer[i] = -1;
            } else {
                int start = 0;
                int end = increase.length - 1;
                int k = 0;
                while (start <= end) {
                    k = (start + end) / 2;
                    if (compare(increase[k], requirements[i])) {
                        if (k==0||!compare(increase[k - 1], requirements[i])) {   //找到准确天数
                            answer[i] = k + 1;
                            break;
                        } else {   //向下搜索
                            end = k - 1;
                        }
                    } else {   //向上搜索
                        start = k + 1;
                    }
                }
            }
        }

        return answer;
    }

    boolean compare(int[] a, int[] b) {
        if (a[0] >= b[0] & a[1] >= b[1] & a[2] >= b[2]) {
            return true;
        } else {
            return false;
        }
    }
}