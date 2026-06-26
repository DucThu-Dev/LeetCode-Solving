package interview100questions

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var max = 0
        val set = HashSet<Char>()
        for(right in s.indices) {
            while(set.contains(s[right])) {
                set.remove(s[left])
                left++
            }
            set.add(s[right])
            max = max.coerceAtLeast(set.size)
        }

        return max
    }
}