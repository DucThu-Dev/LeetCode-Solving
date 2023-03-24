fun minReorder(n: Int, connections: Array<IntArray>): Int {
    val map: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()
    var result = 0

    for (c in connections) {
        val result1 = map.getOrElse(c[0]) { mutableMapOf<Int, Int>().also { map[c[0]] = it } }
        result1[c[1]] = 1

        val result2 = map.getOrElse(c[1]) { mutableMapOf<Int, Int>().also { map[c[1]] = it } }
        result2[c[0]] = 0
    }

    fun bfs(node: Int) {
        val queue: MutableList<Int> = mutableListOf()
        val visited = MutableList(n) { false }
        queue.add(node)
        visited[node] = true
        while (queue.isNotEmpty()) {
            val item = queue.removeAt(0)
            if (map[item] == null) continue
            for (p in map[item]!!) {
                if (!visited[p.key]) {
                    result += p.value
                    visited[p.key] = true
                    queue.add(p.key)
                }
            }
        }
    }
    bfs(0)
    return result
}

fun minReorderPractice(n: Int, connections: Array<IntArray>): Int {
    val map: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()
    for (i in 0 until n) map[i] = mutableMapOf()

    for (c in connections) {
        map[c[0]]!![c[1]] = 1
        map[c[1]]!![c[0]] = 0
    }

    var result = 0

    fun bfs(node: Int) {
        val queue = mutableListOf<Int>(node)
        val visited = MutableList(n) { false }
        visited[0] = true
        while (queue.isNotEmpty()) {
            val curNode = queue.removeAt(0)
            for (p in map[curNode]!!) {
                if (visited[p.key]) continue
                visited[p.key] = true
                result += p.value
                queue.add(p.key)
            }
        }
    }

    bfs(0)
    return result
}