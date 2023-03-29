fun mincostTickets(days: IntArray, costs: IntArray): Int {
    val dp = IntArray(366)
    val isTraveling = MutableList<Boolean>(366) { false }

    for (day in days) {
        isTraveling[day] = true
    }

    for (i in 1..365) {
        if (!isTraveling[i]) {
            dp[i] = dp[i - 1]
            continue
        }
        val min7 = if (i - 7 >= 0) dp[i - 7] else 0
        val min30 = if (i - 30 >= 0) dp[i - 30] else 0
        var min = Math.min(dp[i - 1] + costs[0], min7 + costs[1])
        min = Math.min(min, min30 + costs[2])
        dp[i] = min
    }

    return dp[days.last()]
}

fun main() {
    mincostTickets(intArrayOf(1,4,6,7,8,20), intArrayOf(2,7,15))
}