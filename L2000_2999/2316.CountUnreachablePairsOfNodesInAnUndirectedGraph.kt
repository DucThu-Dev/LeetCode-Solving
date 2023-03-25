fun countPairs(n: Int, edges: Array<IntArray>): Long {
    val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    for (i in 0 until n) graph[i] = mutableListOf()

    for (e in edges) {
        graph[e[0]]!!.add(e[1])
        graph[e[1]]!!.add(e[0])
    }

    var result = 0L
    val graphVisitedNodes = MutableList(n) { false }

    fun traversal(node: Int) {

        val queue = mutableListOf(node)
        var scopeVisitedCount = 1

        graphVisitedNodes[node] = true

        while (queue.isNotEmpty()) {
            val item = queue.removeAt(0)
            for (n in graph[item]!!) {
                if (graphVisitedNodes[n]) continue
                graphVisitedNodes[n] = true
                scopeVisitedCount++
                queue.add(n)
            }
        }
        val unvisitedGraphCount = graphVisitedNodes.count { !it }

        result += scopeVisitedCount * unvisitedGraphCount
        val unvisitedGraphNode = graphVisitedNodes.indexOfFirst { !it }
        if (unvisitedGraphNode != -1) traversal(unvisitedGraphNode)
    }

    traversal(0)

    return result
}

fun main() {
    countPairs(3, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2)))
}