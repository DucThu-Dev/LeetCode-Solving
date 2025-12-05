
import java.util.HashMap;

class Solution {

    public int countPartitions(int[] nums) {
        final int n = nums.length;
        int result = 0;

        HashMap<Integer, Integer> memoizeForward = new HashMap<>();
        HashMap<Integer, Integer> memoizeRevert = new HashMap<>();

        memoizeForward.put(0, nums[0]);
        memoizeRevert.put(n - 1, nums[n - 1]);

        for (int i = 1; i < n - 1; i++) {
            memoizeForward.put(i, memoizeForward.get(i - 1) + nums[i]);
        }

        for (int i = n - 2; i > 0; i--) {
            memoizeRevert.put(i, memoizeRevert.get(i + 1) + nums[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if ((memoizeForward.get(i) - memoizeRevert.get(i + 1)) % 2 == 0) {
                result++;
            }
        }

        return result;
    }
}

class Solution2 {

    public int countPartitions(int[] nums) {
        final int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int left = 0;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            left += nums[i];
            int right = total - left;
            if (left % 2 == right % 2) {
                result++;
            }
        }
        return result;
    }
}
