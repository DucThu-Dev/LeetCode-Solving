fun main() {
//    val trie = Triee<Char>()
//    trie.insert("cute")
//    if (trie.contains("cute")) {
//        println("cute is in the trie")
//    }

    val trie = Triee<Char>().apply {
        insert("car")
        insert("card")
        insert("care")
        insert("cared")
        insert("cars")
        insert("carbs")
        insert("carapace")
        insert("cargo")
    }
    println("\nCollections starting with \"car\"")
    val prefixedWithCar = trie.collections("car")
    println(prefixedWithCar)
    println("\nCollections starting with \"care\"")
    val prefixedWithCare = trie.collections("care")
    println(prefixedWithCare)
}

class Triee<Key> {
    private val root = TrieeNode<Key>(null, null)

    fun insert(list: List<Key>) {
        var current = root
        list.forEach { element ->
            if (current.children[element] == null) {
                current.children[element] = TrieeNode(element, current)
            }
            current = current.children[element]!!
        }

        current.isTerminating = true
    }

    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }

        return current.isTerminating
    }

    fun remove(collection: List<Key>) {
        var current = root
        collection.forEach {
            val child = current.children[it] ?: return
            current = child
        }

        if (!current.isTerminating) return
        current.isTerminating = false

        val parent = current.parent
        while (current.children.isEmpty() && !current.isTerminating) {
            parent?.let {
                it.children.remove(current.key!!)
                current = it
            }
        }
    }

    fun collections(prefix: List<Key>): List<List<Key>> {
        var current = root

        prefix.forEach { element ->
            val child = current.children[element] ?: return emptyList()
            current = child
        }

        return collections(prefix, current)
    }

    fun collections(prefix: List<Key>, node: TrieeNode<Key>?): List<List<Key>> {
        val results = mutableListOf<List<Key>>()

        if (node?.isTerminating == true) {
            results.add(prefix)
        }

        node?.children?.forEach { (key, node) ->
            results.addAll(collections(prefix + key, node))
        }

        return results
    }
}

class TrieeNode<Key>(var key: Key?, var parent: TrieeNode<Key>?) {

    val children: HashMap<Key, TrieeNode<Key>> = HashMap()

    var isTerminating = false
}

fun Triee<Char>.insert(string: String) {
    insert(string.toList())
}

fun Triee<Char>.contains(string: String): Boolean {
    return contains(string.toList())
}

fun Triee<Char>.remove(string: String) {
    remove(string.toList())
}

fun Triee<Char>.collections(prefix: String): List<String> {
    return collections(prefix.toList()).map { it.joinToString(separator = "") }
}