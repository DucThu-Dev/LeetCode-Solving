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
//                edges[node] = -1
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

fun main() {
    longestCycle(intArrayOf(3, 3, 4, 2, 3))
}

fun longestCyclePractice(edges: IntArray): Int {
    var ans = -1

    fun traversal(node: Int) {
        var nextNode = node
        val steps = mutableMapOf<Int, Int>()
        var cntr = 0

        while (true) {
            cntr++
            if (steps[nextNode] != null) {
                ans = ans.coerceAtLeast(cntr - steps[nextNode]!!)
                break
            }

            steps[nextNode] = cntr

            if (edges[nextNode] != -1) {
                val next = edges[nextNode]
                edges[nextNode] = -1
                nextNode = next
            } else {
                break
            }
        }
    }

    for (i in edges.indices) {
        if (edges[i] != -1) traversal(i)
    }

    return ans
}