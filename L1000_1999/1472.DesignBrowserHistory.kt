class BrowserHistory(homepage: String) {

    val historyStack = ArrayDeque<String>().apply {
        addLast(homepage)
    }

    val forwardStack = ArrayDeque<String>()

    fun visit(url: String) {
        historyStack.addLast(url)
        forwardStack.clear()
    }

    fun back(steps: Int): String {
        for (i in 0 until steps) {
            if (historyStack.size > 1) {
                val url = historyStack.removeLast()
                forwardStack.addLast(url)
            }
        }
        return historyStack.last()
    }

    fun forward(steps: Int): String {
        for (i in 0 until steps) {
            if (forwardStack.isNotEmpty()) {
                val url = forwardStack.removeLast()
                historyStack.addLast(url)
            }
        }
        return historyStack.last()
    }

}