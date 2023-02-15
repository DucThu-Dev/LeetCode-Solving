class RomanToInteger {
    fun romanToInt(s: String): Int {
        val map = mapOf(
                'I' to 1,
                'V' to 5,
                'X' to 10,
                'L' to 50,
                'C' to 100,
                'D' to 500,
                'M' to 1000
        )
        var result = 0
        var prev = 0
        for (i in s.length - 1 downTo 0) {
            val curr = map[s[i]] ?: return 0
            if (curr < prev) result -= curr
            else result += curr
            prev = curr
        }
        return result
    }

}