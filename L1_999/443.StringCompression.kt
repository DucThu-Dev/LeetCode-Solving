fun compress(chars: CharArray): Int {
    println(chars)
    var rem = 0
    var currentChar = chars.first()
    var charCount = 1
    for (c in chars.slice(1..chars.lastIndex)) {
        if (c == currentChar) {
            charCount++
        } else {
            currentChar = c
            charCount = 1
            rem += if (charCount > 1) charCount.toString().length + 1 else 1
        }
    }
    rem += if (charCount > 0) charCount.toString().length + 1 else 1
    return rem
}