fun longestPalindromeBestSolutionCloned(s: String): String {
    if (s.isEmpty() || s.length == 1) return s
    var start = 0
    var end = 0

    for (i in 0 until s.lastIndex) {
        val odd = checkExpandHorizontal(s, i, i)
        val even = checkExpandHorizontal(s, i, i + 1)
        val effectiveLength = Math.max(odd, even)
        if (end - start + 1 < effectiveLength) {
            start = i - (effectiveLength - 1) / 2
            end = i + effectiveLength / 2
        }
    }
    return s.substring(start, end + 1)
}

fun checkExpandHorizontal(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right
    while (l >= 0 && r <= s.lastIndex && s[l] == s[r]) {
        l--
        r++
    }
    return r - l - 1
}

fun longestPalindromeDP(s: String): String {
    val n = s.length
    var result = ""

    val dp: MutableList<MutableList<Boolean>> = MutableList(n) { MutableList(n) { false } }

    for (i in n - 1 downTo 0) {
        for (j in i until n) {
            dp[i][j] = s[i] == s[j] && (j - i < 3 || dp[i + 1][j - 1])
            if (dp[i][j] && (result.isEmpty() || result.length < j - i + 1)) {
                result = s.substring(i, j + 1)
            }
        }
    }

    return result
}

fun longestPalindromeDP(s: String)