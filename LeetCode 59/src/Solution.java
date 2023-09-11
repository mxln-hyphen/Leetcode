class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateMatrix(1));
    }

    public int[][] generateMatrix(int n) {
        int[][] distance = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] answer = new int[n][n];
        int k = 1;
        int i = 0;
        int j = 0;
        int x = 0;
        while (k <= n * n) {
            answer[i][j] = k;
            i += distance[x][0];
            j += distance[x][1];
            if (i + distance[x][0] >= n || i + distance[x][0] < 0
                    || j + distance[x][1] >= n || j + distance[x][1] < 0
                    || answer[i + distance[x][0]][j + distance[x][1]] != 0) {
                x = (x + 1) % 4;
            }
            k++;
        }

        return answer;
    }
}