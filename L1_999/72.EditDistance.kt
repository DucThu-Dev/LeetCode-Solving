fun minDistance(word1: String, word2: String): Int {
    if (word1 == word2) return 0
    if (word1 in word2 || word2 in word1) return Math.abs(word1.length - word2.length)

    return Math.min(minDistanceLeftToRight(word1, word2), minDistanceLeftToRight(word1.reversed(), word2.reversed()))
}

fun minDistanceLeftToRight(word1: String, word2: String): Int {
    // Pair with index of word1 - word2
    var firstMatchIndex: Pair<Int, Int>? = null
    var lastMatchIndex: Pair<Int, Int>? = null

    var startIndexWord2 = 0
    var taskToDoCount = 0

    for (i in word1.indices) {
        for (j in startIndexWord2..word2.lastIndex) {
            if (word1[i] == word2[j]) {
                if (firstMatchIndex == null) firstMatchIndex = Pair(i, j)

                if (lastMatchIndex != null) {
                    taskToDoCount += Math.max(i - lastMatchIndex.first - 1, j - lastMatchIndex.second - 1)
                }

                lastMatchIndex = Pair(i, j)
                startIndexWord2 = j + 1
                break
            }
        }
    }

    /// Handle case don't have any match char
    if (firstMatchIndex == null) {
        return Math.max(word1.length, word2.length)
    }

    taskToDoCount += Math.max(firstMatchIndex.first, firstMatchIndex.second)
    taskToDoCount += Math.max((word1.lastIndex - lastMatchIndex!!.first), (word2.lastIndex - lastMatchIndex.second))

    return taskToDoCount
}