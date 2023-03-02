fun compress(chars: CharArray): Int {
    var rem = 0
    var currentChar = chars.first()
    var charCount = 1
    for (c in chars.slice(1..chars.lastIndex)) {
        if (c == currentChar) {
            charCount++
        } else {
            chars[rem++] = currentChar
            if (charCount > 1) {
                val countText = charCount.toString()
                for (i in countText) {
                    chars[rem++] = i
                }
            }
            currentChar = c
            charCount = 1
        }
    }
    chars[rem++] = currentChar
    if (charCount > 1) {
        val countText = charCount.toString()
        for (i in countText) {
            chars[rem++] = i
        }
    }
    return rem
}