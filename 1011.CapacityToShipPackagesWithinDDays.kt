fun shipWithinDays(weights: IntArray, days: Int): Int {
    var lWeight: Int = weights.max() ?: 0
    var rWeight: Int = weights.sum() ?: 0
    if (days == 1) return rWeight

    while (lWeight < rWeight) {
        val middleWeight = lWeight + (rWeight - lWeight) / 2

        var sumWeight = 0
        var countDay: Int = 1
        for (w in weights) {
            val nextSumWeight = sumWeight + w
            sumWeight = if (nextSumWeight <= middleWeight) {
                nextSumWeight
            } else {
                countDay++
                w
            }
        }

        if (countDay <= days) {
            rWeight = middleWeight
        } else {
            lWeight = middleWeight + 1
        }
    }

    return lWeight
}