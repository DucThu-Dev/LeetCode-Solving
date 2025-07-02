class Solution {
  int possibleStringCount(String word, int k) {
    final n = word.length;
    final charCounts = <int>[];
    int result = 0;

    int index = 0;
    String char = word[0];
    int count = 0;

    while (index < n) {
      if (char == word[index]) {
        count++;
      } else {
        charCounts.add(count);

        char = word[index];
        count = 1;
      }

      index++;
    }

    /// Add the the last char count.
    charCounts.add(count);

    result += countPossible(charCounts, k, charCounts.reduce((prev, cur) => prev + cur), 0, 1);

    return result;
  }

  int countPossible(List<int> charCounts, int k, int sum, int checkIndex, int initResult) {
    if (sum < k) return 0;
    if (sum == k) return 1;

    int result = initResult;
    if (charCounts[checkIndex] > 1) {
      charCounts[checkIndex]--;
      result += countPossible(charCounts, k, sum - 1, checkIndex, 1);
      charCounts[checkIndex]++;
    }

    if (checkIndex < charCounts.length - 1) {
      result += countPossible(charCounts, k, sum, checkIndex + 1, 0);
    }

    return result;
  }
}

class SolutionResult {
  static const int MOD = 1000000007;

  int possibleStringCount(String word, int k) {
    if (word.isEmpty) return 0;

    final List<int> groups = [];

    // Count consecutive character groups
    int count = 1;
    for (int i = 1; i < word.length; i++) {
      if (word[i] == word[i - 1]) {
        count++;
      } else {
        groups.add(count);
        count = 1;
      }
    }
    groups.add(count); // Add the last group

    // Total combinations = product of each group count
    int total = 1;
    for (final num in groups) {
      total = (total * num) % MOD;
    }

    // If all strings must be at least of length k or smaller, return early
    if (k <= groups.length) return total;

    // DP to count number of combinations with length < k
    List<int> dp = List.filled(k, 0);
    dp[0] = 1;

    for (final num in groups) {
      List<int> newDp = List.filled(k, 0);
      int sum = 0;
      for (int s = 0; s < k; s++) {
        if (s > 0) {
          sum = (sum + dp[s - 1]) % MOD;
        }
        if (s > num) {
          sum = (sum - dp[s - num - 1] + MOD) % MOD;
        }
        newDp[s] = sum;
      }
      dp = newDp;
    }

    // Subtract invalid combinations (length < k)
    int invalid = 0;
    for (int s = groups.length; s < k; s++) {
      invalid = (invalid + dp[s]) % MOD;
    }

    return (total - invalid + MOD) % MOD;
  }
}
