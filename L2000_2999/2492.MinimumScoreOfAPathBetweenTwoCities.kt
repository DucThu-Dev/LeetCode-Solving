fun minScore(n: Int, roads: Array<IntArray>): Int {
    val map: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()

    for (r in roads) {
        val city1 = r[0]
        val city2 = r[1]
        val distance = r[2]
        val result1 = map.getOrElse(city1) {
            mutableMapOf(city2 to distance).also { map[city1] = it }
        }
        result1.computeIfAbsent(city2) { distance }
        val result2 = map.getOrElse(city2) {
            mutableMapOf(city1 to distance).also { map[city2] = it }
        }
        result2.computeIfAbsent(city1) { distance }
    }

    var minScore: Int = Int.MAX_VALUE
    val passedCities: MutableMap<Int, MutableMap<Int, Boolean>> = mutableMapOf()

    fun traversal(start: Int, cities: Map<Int, Int>) {
        for (entry in cities) {
            if (passedCities[start]?.get(entry.key) == null) {
                minScore = entry.value.coerceAtMost(minScore)
                val result1 = passedCities.getOrElse(start) {
                    mutableMapOf(entry.key to true).also { passedCities[start] = it }
                }
                result1.computeIfAbsent(entry.key) { true }
                val result2 = passedCities.getOrElse(entry.key) {
                    mutableMapOf(start to true).also { passedCities[entry.key] = it }
                }
                result2.computeIfAbsent(entry.key) { true }
                traversal(entry.key, map[entry.key]!!)
            }
        }
    }

    traversal(1, map[1]!!)

    return minScore
}

fun main() {
    minScore(
        4,
        arrayOf(intArrayOf(1, 2, 9), intArrayOf(2, 3, 6), intArrayOf(2, 4, 5), intArrayOf(1, 4, 7))
    )
}