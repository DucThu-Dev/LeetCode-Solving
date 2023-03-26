//fun main() {
//    val graph = AdjacencyList<String>()
//    val singapore = graph.createVertex("Singapore")
//    val tokyo = graph.createVertex("Tokyo")
//    val hongKong = graph.createVertex("Hong Kong")
//    val detroit = graph.createVertex("Detroit")
//    val sanFrancisco = graph.createVertex("San Francisco")
//    val washingtonDC = graph.createVertex("Washington DC")
//    val austinTexas = graph.createVertex("Austin Texas")
//    val seattle = graph.createVertex("Seattle")
//    graph.add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
//    graph.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
//    graph.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
//    graph.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
//    graph.add(EdgeType.UNDIRECTED, tokyo, washingtonDC, 300.0)
//    graph.add(EdgeType.UNDIRECTED, hongKong, sanFrancisco, 600.0)
//    graph.add(EdgeType.UNDIRECTED, detroit, austinTexas, 50.0)
//    graph.add(EdgeType.UNDIRECTED, austinTexas, washingtonDC, 292.0)
//    graph.add(
//        EdgeType.UNDIRECTED, sanFrancisco, washingtonDC,
//        337.0
//    )
//    graph.add(EdgeType.UNDIRECTED, washingtonDC, seattle, 277.0)
//    graph.add(EdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
//    graph.add(EdgeType.UNDIRECTED, austinTexas, sanFrancisco, 297.0)
//
//    println(graph)
//    println("San Francisco Outgoing Flights:")
//    println("--------------------------------")
//    graph.edges(sanFrancisco).forEach { edge ->
//        println("from: ${edge.source.data} to: ${edge.destination.data}")
//    }
//}

fun main() {
    val graph = AdjacencyMatrix<String>()
    val singapore = graph.createVertex("Singapore")
    val tokyo = graph.createVertex("Tokyo")
    val hongKong = graph.createVertex("Hong Kong")
    val detroit = graph.createVertex("Detroit")
    val sanFrancisco = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val austinTexas = graph.createVertex("Austin Texas")
    val seattle = graph.createVertex("Seattle")
    graph.add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
    graph.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, washingtonDC, 300.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, sanFrancisco, 600.0)
    graph.add(EdgeType.UNDIRECTED, detroit, austinTexas, 50.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, washingtonDC, 292.0)
    graph.add(
        EdgeType.UNDIRECTED, sanFrancisco, washingtonDC,
        337.0
    )
    graph.add(EdgeType.UNDIRECTED, washingtonDC, seattle, 277.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, sanFrancisco, 297.0)

    println(graph)
    println("San Francisco Outgoing Flights:")
    println("--------------------------------")
    graph.edges(sanFrancisco).forEach { edge ->
        println("from: ${edge.source.data} to: ${edge.destination.data}")
    }
}

class AdjacencyMatrix<T> : Graph<T> {
    private val vertices = arrayListOf<Vertex<T>>()
    private val weights = arrayListOf<ArrayList<Double?>>()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(vertices.count(), data)
        vertices.add(vertex)
        weights.forEach {
            it.add(null)
        }
        val row = ArrayList<Double?>(vertices.count())
        repeat(vertices.count()) {
            row.add(null)
        }

        weights.add(row)

        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        weights[source.index][destination.index] = weight
    }

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when (edge) {
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
        }
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        val edges = arrayListOf<Edge<T>>()
        (0 until weights.size).forEach { column ->
            val weight = weights[source.index][column]
            if (weight != null) {
                edges.add(Edge(source, vertices[column], weight))
            }
        }
        return edges
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return weights[source.index][destination.index]
    }

    override fun toString(): String {
        val verticesDescription = vertices.joinToString("\n") {
            "${it.index}: ${it.data}"
        }

        val grid = arrayListOf<String>()
        weights.forEach {
            var row = ""
            (0 until weights.size).forEach { columnIndex ->
                if (columnIndex >= it.size) {
                    row += "ø\t\t"
                } else {
                    row += it[columnIndex]?.let { "$it\t" } ?: "ø\t\t"
                }
            }
            grid.add(row)
        }
        val edgesDescription = grid.joinToString("\n")
        return "$verticesDescription\n\n$edgesDescription"
    }

}

class AdjacencyList<T> : Graph<T> {
    private val adjacencies: HashMap<Vertex<T>, ArrayList<Edge<T>>> = HashMap()
    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        adjacencies[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when (edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        return adjacencies[source] ?: arrayListOf()
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull { it.destination == destination }?.weight
    }

    override fun toString(): String {
        return buildString {
            adjacencies.forEach { (vertex, edges) ->
                val edgeString = edges.joinToString {
                    it.destination.data.toString()
                }
                append("${vertex.data} ---> [ $edgeString ]\n")
            }
        }
    }
}

interface Graph<T> {
    fun createVertex(data: T): Vertex<T>

    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)

    fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)

    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?)

    fun edges(source: Vertex<T>): ArrayList<Edge<T>>

    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?
}

enum class EdgeType {
    DIRECTED, UNDIRECTED
}

data class Vertex<T>(val index: Int, val data: T)

data class Edge<T>(
    val source: Vertex<T>,
    val destination: Vertex<T>,
    val weight: Double? = null,
)