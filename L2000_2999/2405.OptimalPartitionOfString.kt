fun partitionString(s: String): Int {
    if (s.isEmpty()) return 0
    var startIndex = 0
    var count = 1

    fun containCharAtIndexInSubString(index: Int): Boolean {
        return s.substring(startIndex..index - 1).contains(s[index])
    }

    for (i in 1..s.lastIndex) {
        if (containCharAtIndexInSubString(i)) {
            startIndex = i
            count++
        }
    }
    return count
}