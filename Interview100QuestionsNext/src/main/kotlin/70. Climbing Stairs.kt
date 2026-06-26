class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        val countMap = mutableMapOf<Int, Int>()
        countMap[1] = 1
        countMap[2] = 2

        fun dp(x: Int): Int {
            if (!countMap.contains(x - 2)) dp(x - 2)
            if (!countMap.contains(x - 1)) dp(x - 1)
            val sum: Int = countMap[x - 1]!! + countMap[x - 2]!!
            countMap[x] = sum
            return sum
        }

        return dp(n)
    }
}