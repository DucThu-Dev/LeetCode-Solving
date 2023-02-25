package L1_999

fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    if (s.length == 1) return 1

    var start: Int = 0
    var end: Int = 0
    val sLastIndex = s.lastIndex

    var currentStart = 0
    var remQueue = mutableListOf<Char>()


    for (i in s.indices) {
        if (remQueue.contains(s[i])) {
            if (end - start + 1 < remQueue.size) {
                start = currentStart
                end = currentStart + remQueue.lastIndex
            }
            // Get index of i in remQueue
            val indexInRem = remQueue.indexOf(s[i])
            currentStart += indexInRem + 1
            remQueue = remQueue.drop(indexInRem + 1).toMutableList()
        }
        remQueue.add(s[i])

        if (i == sLastIndex) {
            if (end - start + 1 < remQueue.size) {
               return remQueue.size
            }
        }
    }

    return end - start + 1
}