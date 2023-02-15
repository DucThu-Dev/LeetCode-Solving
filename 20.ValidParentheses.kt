import java.util.*

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val openBrackets = listOf('{', '[', '(')
        val closeBrackets = listOf('}', ']', ')')

        if (s.length % 2 != 0) return false
        val currentQueue: Stack<Char> = Stack<Char>()
        for (i in s.indices) {
            val currentC = s[i]
            if (openBrackets.contains(currentC)) {
                currentQueue.push(currentC)
            } else {
                if (currentQueue.isEmpty()) return false
                val lastC = currentQueue.last()
                when (currentC) {
                    '}' -> if (lastC != '{') return false else currentQueue.pop()
                    ')' -> if (lastC != '(') return false else currentQueue.pop()
                    ']' -> if (lastC != '[') return false else currentQueue.pop()
                    else -> {}
                }
            }
        }
        return currentQueue.isEmpty()
    }
}