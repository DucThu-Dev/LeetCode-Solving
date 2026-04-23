package interview100questions

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (true) {
            val sum = numbers[left] + numbers[right]
            if(sum < target) {
                left++
            } else if(sum > target) {
                right--
            } else return intArrayOf(left + 1, right + 1)
        }

        return intArrayOf()
    }
}