fun minDistance(word1: String, word2: String): Int {
    if (word1 == word2) return 0
    if (word1 in word2 || word2 in word1) return Math.abs(word1.length - word2.length)

    return Math.min(minDistanceLeftToRight(word1, word2), minDistanceLeftToRight(word1.reversed(), word2.reversed()))
}

fun minDistanceLeftToRight(word1: String, word2: String): Int {
    // Count total char match from word1 to word2
    var totalMatchInOrder = 0
    var lastMatchIndex = 0
    var consecutiveUnMatchCount = 0
    var taskToDoCount = 0

    for (i in word1.indices) {
        for (j in lastMatchIndex + 1 until word2.length) {
            if (word1[i] == word2[j]) {
                if (j - lastMatchIndex - 1 > consecutiveUnMatchCount) {
                    taskToDoCount += j - lastMatchIndex - consecutiveUnMatchCount - 1
                }
                lastMatchIndex = j
                totalMatchInOrder++
                consecutiveUnMatchCount = 0
                break
            } else if (j == word2.lastIndex) {
                consecutiveUnMatchCount++
            }
        }
    }

    return word1.length - totalMatchInOrder
}