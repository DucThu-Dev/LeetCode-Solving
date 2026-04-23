class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        val graph = HashMap<Node, Node>()

        fun cloneNode(node: Node?): Node? {
            if (node == null) return null
            if (graph.contains(node)) return graph[node]!!
            val newNode = Node(node.`val`)
            graph[node] = newNode
            for (n in node.neighbors) {
                val c = cloneNode(n)
                if (c != null)
                    newNode.neighbors.add(c)

            }
            return newNode
        }

        return cloneNode(node)
    }
}

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}