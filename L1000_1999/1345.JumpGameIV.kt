fun minJumps(arr: IntArray): Int {
    if (arr.size <= 1) return 0
    if (arr.first() == arr.last()) return 1
    val n = arr.size

    val graph = mutableMapOf<Int, MutableList<Int>>()

    for (i in arr.indices) {
        graph.getOrElse(arr[i]) { mutableListOf<Int>().also { graph[arr[i]] = it } }.add(i)
    }

    var curs = mutableListOf<Int>().also { it.add(0) }
    val visited = mutableSetOf<Int>()
    var step = 0

    while (curs.isNotEmpty()) {
        val nex = mutableListOf<Int>()

        for (nodeIndex in curs) {
            if (nodeIndex == n - 1) return step
            for (child in graph.get(arr[nodeIndex])!!) {
                if (!visited.contains(child)) {
                    visited.add(child)
                    nex.add(child)
                }
            }

            /**
             * NOTE: THIS IS IMPORTANT
             */
            graph.get(arr[nodeIndex])!!.clear()

            if (nodeIndex + 1 < n && !visited.contains(nodeIndex + 1)) {
                visited.add(nodeIndex + 1)
                nex.add(nodeIndex + 1)
            }

            if (nodeIndex - 1 >= 0 && !visited.contains(nodeIndex - 1)) {
                visited.add(nodeIndex - 1)
                nex.add(nodeIndex - 1)
            }
        }

        curs = nex
        step++
    }

    return -1
}

fun main() {
    val result = minJumps(intArrayOf(100, -23, -23, 404, 100, 23, 23, 23, 3, 404))

    println(result)
}

fun minJumpsPractice(arr: IntArray): Int {
    if (arr.size <= 1) return 0
    if (arr.first() == arr.last()) return 1

    val n = arr.size
    val graph = mutableMapOf<Int, MutableList<Int>>()

    for (i in arr.indices) {
        graph.getOrElse(arr[i]) { mutableListOf<Int>().also { graph[arr[i]] = it } }.add(i)
    }

    var curs = mutableListOf<Int>(0)
    val visited = mutableSetOf<Int>()
    var steps = 0

    while (curs.isNotEmpty()) {
        val nex = mutableListOf<Int>()
        for (i in curs) {
            if (i == n - 1) return steps

            for (j in graph[arr[i]]!!) {
                if (!visited.contains(j)) {
                    nex.add(j)
                    visited.add(j)
                }
            }

            graph[arr[i]]!!.clear()

            if (i + 1 < n && !visited.contains(i + 1)) {
                visited.add(i + 1)
                nex.add(i + 1)
            }

            if (i - 1 >= 0 && !visited.contains(i - 1)) {
                visited.add(i - 1)
                nex.add(i - 1)
            }
        }

        curs = nex
        steps++
    }

    return -1
}