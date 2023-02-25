import java.util.PriorityQueue

fun maxProfit(prices: IntArray): Int {
    var maxProfit = Int.MIN_VALUE
    var maxPrice = prices.last()

    for (i in (0 until prices.lastIndex).reversed()) {
        maxProfit = if (maxPrice - prices[i] > maxProfit) maxPrice - prices[i] else maxProfit
        maxPrice = if (maxPrice > prices[i]) maxPrice else prices[i]
    }

    return if (maxProfit > 0) maxProfit else 0
}