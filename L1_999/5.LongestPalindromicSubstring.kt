/**
 *  Best solution
 */
fun longestPalindromeBestSolution(s: String): String {
    if (s.isEmpty()) return ""
    if (s.length == 1) return s

    var start = 0
    var end = 0

    for (i in 0 until s.lastIndex) {
        val odd = expandHorizontalCheck(s, i, i)
        val even = expandHorizontalCheck(s, i, i + 1)

        val effectiveLen = Math.max(odd, even)

        if (effectiveLen > end - start + 1) {
            start = i - (effectiveLen - 1) / 2
            end = i + effectiveLen / 2
        }
    }

    return s.substring(start, end + 1)
}

fun expandHorizontalCheck(s: String, start: Int, end: Int): Int {
    var left = start
    var right = end
    while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
        left--
        right++
    }
    return right - left - 1
}


/**
 *  My original solution
 */
fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""
    if (s.length == 1) return s

    var longest = ""

    for (i in 0 until s.lastIndex) {
        val nextStartJ = i + longest.length
        for (j in nextStartJ..s.lastIndex) {
            if (s[i] == s[j] && j - i + 1 > longest.length) {
                val isPal = isPalindromic(s.substring(i, j + 1))
                if (isPal) {
                    longest = s.substring(i, j + 1)
                }
            }
        }
    }

    return longest
}

fun isPalindromic(text: String): Boolean {
    return text.equals(text.reversed())
}

