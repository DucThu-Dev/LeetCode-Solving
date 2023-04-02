fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    potions.sort()
    val counted: MutableMap<Int, Int> = mutableMapOf()
    val pair = IntArray(spells.size) { 0 }

    fun binarySearch(target: Long): Int {
        if(target > potions.last()) return -1
        var start = 0
        var end = potions.lastIndex
        while (start < end) {
            val middle = start + (end - start) / 2
            if (potions[middle] < target) {
                start = middle + 1
            } else {
                end = middle
            }
        }
        return if (potions[start] >= target) start
        else -1
    }

    for (i in spells.indices) {
        if (counted.containsKey(spells[i])) {
            pair[i] = counted[spells[i]]!!
            continue
        }
        var target: Long = success / spells[i]
        if (success % spells[i] != 0L) target++
        val indexOfFirstSuccess = binarySearch(target)
        val result = if (indexOfFirstSuccess != -1) potions.size - indexOfFirstSuccess else 0
        pair[i] = result
        counted[spells[i]] = result
    }

    return pair
}