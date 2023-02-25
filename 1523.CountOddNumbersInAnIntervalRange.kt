fun countOdds(low: Int, high: Int): Int {
    if (low == high) {
        return if (low % 2 == 1) {
            1
        } else {
            0
        }
    }

    var startLow = if (low % 2 == 1) low else low + 1

    return (high - startLow) / 2 + 1
}