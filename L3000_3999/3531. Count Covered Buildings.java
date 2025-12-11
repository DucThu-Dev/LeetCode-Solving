
import java.util.Arrays;

class Solution {

    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] minRows = new int[n + 1];
        int[] maxRows = new int[n + 1];
        int[] minColumns = new int[n + 1];
        int[] maxColumns = new int[n + 1];

        Arrays.fill(minRows, n + 1);
        Arrays.fill(minColumns, n + 1);

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            minRows[y] = Math.min(minRows[y], x);
            maxRows[y] = Math.max(maxRows[y], x);
            minColumns[x] = Math.min(minColumns[x], y);
            maxColumns[x] = Math.max(maxColumns[x], y);
        }

        int result = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if (x > minRows[y] && x < maxRows[y] && y > minColumns[x] && y < maxColumns[x]) {
                result++;
            }
        }

        return result;
    }
}
