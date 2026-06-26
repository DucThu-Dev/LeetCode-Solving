package interview100questions

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minPrice = Int.MAX_VALUE

        for(right in prices.indices) {
            if(prices[right] < minPrice) {
                minPrice = prices[right]
            }
            maxProfit = maxProfit.coerceAtLeast(prices[right] - minPrice)
        }

        return maxProfit
    }
}