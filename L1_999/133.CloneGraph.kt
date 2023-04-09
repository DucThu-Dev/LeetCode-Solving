import java.util.*
import kotlin.collections.ArrayList

fun cloneGraph(node: Node?): Node? {
    if (node == null) return null
    val map = mutableMapOf<Int, Node>()
    val adjList = mutableMapOf<Int, MutableSet<Int>>()
    val visited = mutableSetOf<Int>()

    val ret = Node(node.`val`)

    map[node.`val`] = ret
    val queue: Queue<Node> = LinkedList()
    visited.add(node.`val`)
    queue.add(node)

    while (queue.isNotEmpty()) {
        var cur = queue.poll()
        adjList.putIfAbsent(cur.`val`, mutableSetOf())
        for (neighbor in cur.neighbors) {
            map.putIfAbsent(neighbor!!.`val`, Node(neighbor.`val`))
            adjList[cur.`val`]!!.add(neighbor.`val`)
            if (!visited.contains(neighbor.`val`)) {
                queue.add(neighbor)
                visited.add(neighbor.`val`)
            }
        }
    }

    for (nodeVal in adjList.keys) {
        val cur = map[nodeVal]
        for (neighborVal in adjList[nodeVal]!!) {
            cur!!.neighbors.add(map[neighborVal])
        }
    }

    return ret
}

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}