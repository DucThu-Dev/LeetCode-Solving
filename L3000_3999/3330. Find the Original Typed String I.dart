class Solution {
  int possibleStringCount(String word) {
    int n = word.length;
    int result = 1;

    final charCountLists = <int>[];
    int currentIndex = 0;
    String currentChar = word[0];
    int currentCharCount = 0;
    while (currentIndex < n) {
      if (currentChar == word[currentIndex]) {
        currentCharCount++;
      } else {
        charCountLists.add(currentCharCount);
        currentChar = word[currentIndex];
        currentCharCount = 1;
      }
      currentIndex++;
    }

    // The last chars is out of while loop
    charCountLists.add(currentCharCount);

    charCountLists.forEach((count) {
      if (count > 1) {
        result += (count - 1);
      }
    });

    return result;
  }
}
