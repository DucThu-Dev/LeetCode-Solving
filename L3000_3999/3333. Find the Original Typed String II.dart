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
