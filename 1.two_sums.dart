//  Problem src: https://leetcode.com/problems/two-sum/
//   Given an array of integers nums and an integer target,
//   return indices of the two numbers such that they add up to target.
//

class Solution {
  List<int> twoSum(List<int> nums, int target) {
    final count = nums.length;
    int firstNum;
    for (int i = 0; i < count - 1; i++) {
      firstNum = nums[i];
      for (int y = i + 1; y < count; y++) {
        int secondNum = nums[y];
        if (firstNum + secondNum == target) {
          return [i, y];
        }
      }
    }
    throw 'No pair work';
  }
}
