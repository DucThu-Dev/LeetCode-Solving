class Trie() {
    val root: TrieNode = TrieNode()

    fun insert(word: String) {
        var current = root
        for (c in word) {
            if (current.map[c] == null) {
                current.map[c] = TrieNode()
            }
            current = current.map[c]!!
        }

        current.isTerminating = true
    }

    fun search(word: String): Boolean {
        var current = root
        for (c in word) {
            if (current.map[c] == null) {
                return false
            }

            current = current.map[c]!!
        }

        if (current.isTerminating) return true
        return false
    }

    fun startsWith(prefix: String): Boolean {
        var current = root
        for (c in prefix) {
            if (current.map[c] == null) {
                return false
            }

            current = current.map[c]!!
        }

        return true
    }
}

class TrieNode {
    val map: MutableMap<Char, TrieNode> = mutableMapOf()
    var isTerminating: Boolean = false
}