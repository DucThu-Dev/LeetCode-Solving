
import java.util.ArrayList;
import java.util.List;

class Solution {

    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        int startIndex = 0;
        List<Long> periodCount = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int lastPrice = prices[i - 1];
            int price = prices[i];
            if (lastPrice - price != 1) {
                periodCount.add((long) (i - 1 - startIndex + 1));
                startIndex = i;
            }
        }

        periodCount.add((long) (n - 1 - startIndex + 1));

        long result = 0L;
        for (long count : periodCount) {
            result += count * (count + 1) / 2;
        }

        return result;
    }
}
