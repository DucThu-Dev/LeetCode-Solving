package interview100questions

class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0

        while (left < right) {
            max = max.coerceAtLeast((right - left) * height[left].coerceAtMost(height[right]))
            if(height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return max
    }
}