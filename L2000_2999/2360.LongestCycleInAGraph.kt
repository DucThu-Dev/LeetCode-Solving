fun longestCycle(edges: IntArray): Int {
    var ans = -1

    fun go(node: Int) {
        var node = node
        val steps = mutableMapOf<Int, Int>()
        var cntr = 0

        while (true) {
            cntr++
            if (steps[node] != null) {
                ans = Math.max(ans, cntr - steps[node]!!)
                break
            }

            steps[node] = cntr

            if (edges[node] >= 0) {
                val next = edges[node]
                edges[node] = -1
                node = next
            } else {
                break
            }
        }
    }

    for (i in edges.indices) {
        if (edges[i] >= 0) {
            go(i)
        }
    }

    return ans
}