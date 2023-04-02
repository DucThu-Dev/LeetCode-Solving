fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    potions.sort()
    val counted: MutableMap<Int, Int> = mutableMapOf()
    val pair = IntArray(spells.size) { 0 }
    for (i in spells.indices) {
        if (counted.containsKey(spells[i])) {
            pair[i] = counted[spells[i]]!!
            continue
        }
        var target: Long = success / spells[i]
        if (success % spells[i] != 0L) target++
        val indexOfFirstSuccess = potions.indexOfFirst { it >= target }
        val result = if (indexOfFirstSuccess != -1) potions.size - indexOfFirstSuccess else 0
        pair[i] = result
        counted[spells[i]] = result
    }

    return pair
}