fun main() {
//    minDistanceRecursive("dinitrophenylhydrazine", "benzalphenylhydrazone")
//    minDistanceRecursive("abcde", "axbxcxdxe")

    val result = minDistanceDynamicProgramming("dinitrophenylhydrazine", "benzalphenylhydrazone")
    println("Result is $result")

}


/// Memoization - Top-Down Dynamic Programming
fun minDistanceDynamicProgramming(word1: String, word2: String): Int {
    val memo: Array<Array<Int?>> = Array(word1.length + 1) {
        Array<Int?>(word2.length + 1) {
            null
        }
    }

    return minDistanceRecurDynamicProgramming(word1, word2, word1.length, word2.length, memo)
}

fun minDistanceRecurDynamicProgramming(
    word1: String,
    word2: String,
    word1Index: Int,
    word2Index: Int,
    memo: Array<Array<Int?>>
): Int {
    if (word1Index == 0) return word2Index
    if (word2Index == 0) return word1Index

    if (memo[word1Index][word2Index] != null) {
        return memo[word1Index][word2Index]!!
    }

    var minDistanceResult: Int = 0

    if (word1[word1Index - 1] == word2[word2Index - 1]) {
        minDistanceResult = minDistanceRecurDynamicProgramming(word1, word2, word1Index - 1, word2Index - 1, memo)
    } else {
        val deleteResult = minDistanceRecurDynamicProgramming(word1, word2, word1Index - 1, word2Index, memo)
        val insertResult = minDistanceRecurDynamicProgramming(word1, word2, word1Index, word2Index - 1, memo)
        val replaceResult = minDistanceRecurDynamicProgramming(word1, word2, word1Index - 1, word2Index - 1, memo)
        minDistanceResult = Math.min(deleteResult, Math.min(insertResult, replaceResult)) + 1
    }
    println("MinDistanceResult is $minDistanceResult")
    memo[word1Index][word2Index] = minDistanceResult
    return minDistanceResult
}

/// Recursion approach - out of time limit
fun minDistanceRecursive(word1: String, word2: String): Int {
    return minDistanceRecur(word1, word2, word1.length, word2.length).apply { println("Final result is $this") }
}

fun minDistanceRecur(word1: String, word2: String, word1Index: Int, word2Index: Int): Int {
    if (word1Index == 0) return word2Index
    if (word2Index == 0) return word1Index

    println("Working on word1 ${word1.substring(0, word1Index - 1)}")
    println("Working on word2 ${word2.substring(0, word2Index - 1)}")

    if (word1[word1Index - 1] == word2[word2Index - 1]) {
        return minDistanceRecur(word1, word2, word1Index - 1, word2Index - 1).apply {
            println("Word1[${word1Index - 1}] equals Word2[${word2Index - 1}] equals ${word1[word1Index - 1]}")
        }
    } else {
        val insertOperation = minDistanceRecur(word1, word2, word1Index, word2Index - 1)
        val deleteOperation = minDistanceRecur(word1, word2, word1Index - 1, word2Index)
        val replaceOperation = minDistanceRecur(word1, word2, word1Index - 1, word2Index - 1)

        return (Math.min(insertOperation, Math.min(deleteOperation, replaceOperation)) + 1).apply {
            println("The result of compare 3 value is $this")
        }
    }
}

/// The original legacy solution but do not meet all test cases.
/// NOTE: Didn't accepted answer
fun minDistanceLegacy(word1: String, word2: String): Int {
    if (word1 == word2) return 0
    if (word1 in word2 || word2 in word1) return Math.abs(word1.length - word2.length)

    return Math.min(
        minDistanceLeftToRightLegacy(word1, word2),
        minDistanceLeftToRightLegacy(word1.reversed(), word2.reversed())
    )
}

fun minDistanceLeftToRightLegacy(word1: String, word2: String): Int {
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