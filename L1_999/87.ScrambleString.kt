fun isScramble(s1: String, s2: String): Boolean {
    val n = s1.length
    val dp: MutableList<MutableList<MutableList<Boolean>>> =
        MutableList(n + 1) { MutableList(n) { MutableList(n) { false } } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            dp[1][i][j] = s1[i] == s2[j]
        }
    }
    for (length in 2..n) {
        for (i in 0 until n + 1 - length) {
            for (j in 0 until n + 1 - length) {
                for (newLength in 1 until length) {
                    val dp1: MutableList<Boolean> = dp[newLength][i]
                    val dp2: MutableList<Boolean> = dp[length - newLength][i + newLength]
                    dp[length][i][j] = dp[length][i][j] or (dp1[j] and dp2[j + newLength])
                    dp[length][i][j] = dp[length][i][j] or (dp1[j + length - newLength] and dp2[j])
                }
            }
        }
    }

    return dp[n][0][0]
}