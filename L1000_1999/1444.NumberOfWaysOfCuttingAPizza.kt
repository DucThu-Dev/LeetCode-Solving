fun ways(pizza: Array<String>, k: Int): Int {
    val rows = pizza.size
    val cols = pizza.first().length
    val apples = MutableList(rows + 1) { MutableList(cols + 1) { 0 } }
    val dp = MutableList(k) { MutableList(rows) { MutableList(cols) { 0 } } }
    for (row in rows - 1 downTo 0) {
        for (col in cols - 1 downTo 0) {
            apples[row][col] =
                (if (pizza[row][col] == 'A') 1 else 0) + apples[row + 1][col] + apples[row][col + 1] - apples[row + 1][col + 1]
            dp[0][row][col] = if (apples[row][col] > 0) 1 else 0
        }
    }

    val mod = 1000000007
    for (remain in 1 until k) {
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                for (next_row in row + 1 until rows) {
                    if (apples[row][col] - apples[next_row][col] > 0) {
                        dp[remain][row][col] += dp[remain - 1][next_row][col]
                        dp[remain][row][col] %= mod
                    }
                }
                for (next_col in col + 1 until cols) {
                    if (apples[row][col] - apples[row][next_col] > 0) {
                        dp[remain][row][col] += dp[remain - 1][row][next_col]
                        dp[remain][row][col] %= mod
                    }
                }
            }
        }
    }

    return dp[k - 1][0][0]
}