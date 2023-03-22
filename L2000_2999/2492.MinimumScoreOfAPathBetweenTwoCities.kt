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
    val passedCities = mutableMapOf<Int, Boolean>()

    fun traversal(cities: Map<Int, Int>) {
        for (entry in cities) {
            if (passedCities[entry.key] == null || passedCities[entry.key] == false) {
                minScore = entry.value.coerceAtMost(minScore)
                passedCities[entry.key] = passedCities[entry.key] != null
                traversal(map[entry.key]!!)
            }
        }
    }

    traversal(map[1]!!)

    return minScore
}

fun main() {
    minScore(
        4,
        arrayOf(intArrayOf(1, 2, 9), intArrayOf(2, 3, 6), intArrayOf(2, 4, 5), intArrayOf(1, 4, 7))
    )
}