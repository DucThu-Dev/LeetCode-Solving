class WordDictionary() {
    val root = TrieNode()
    fun addWord(word: String) {
        var current: TrieNode = root
        for (c in word) {
            if (current.map[c] == null) {
                current.map[c] = TrieNode()
            }
            current = current.map[c]!!
        }

        current.isTerminating = true
    }

    fun search(word: String): Boolean {
        if (word.isEmpty()) return true
        return searchWord(root, word)
    }

    fun searchWord(current: TrieNode, word: String): Boolean {
        if (word.isEmpty()) return true
        var current = current
        for (i in word.indices) {
            if (word[i] == '.') {
                if (i == word.lastIndex) return current.map.any { it.value.isTerminating }
                return searchAllPossible(current, word.substring(i + 1));
            } else if (current.map[word[i]] != null) {
                current = current.map[word[i]]!!
                continue
            } else {
                return false
            }
        }
        return current.isTerminating
    }

    fun searchAllPossible(current: TrieNode, word: String): Boolean {
        if (word.isEmpty()) return true
        for (entry in current.map) {
            val result = searchWord(entry.value, word)
            if (result) return true
        }
        return false
    }
}