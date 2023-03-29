fun maxSatisfaction(satisfaction: IntArray): Int {
    satisfaction.sort()
    var currentIndex = satisfaction.indexOfFirst { it >= 0 }
    if (currentIndex == -1) return 0

    var continueCheck = true
    var maxResult = 0
    while (continueCheck) {
        continueCheck = false
        val validateResult = validate(satisfaction.sliceArray(currentIndex until satisfaction.size))
        if (validateResult > maxResult) {
            maxResult = validateResult
            if (currentIndex == 0) break
            currentIndex--
            continueCheck = true
        }
    }

    return maxResult
}

fun validate(satisfaction: IntArray): Int {
    var result = 0
    for (i in 1..satisfaction.size) {
        result += i * satisfaction[i - 1]
    }

    return result
}