fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""
    if (s.length == 1) return s

    var longest = ""

    for (i in 0 until s.lastIndex) {
        for (j in i..s.lastIndex) {
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