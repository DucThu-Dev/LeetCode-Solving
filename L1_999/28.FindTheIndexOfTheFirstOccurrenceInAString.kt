fun strStr(haystack: String, needle: String): Int {
    if (haystack == needle) return 0
    if (haystack.length < needle.length) return -1
    for (i in haystack.indices) {
        if (needle.first() == haystack[i]) {
            if (needle == haystack.substring(i, (i + needle.length).coerceAtMost(haystack.length))) return i
        }
    }

    return -1
}