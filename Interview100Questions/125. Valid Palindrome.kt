package interview100questions

class Solution {
    fun isPalindrome(s: String): Boolean {
        val s = s.lowercase()
        val chars = mutableListOf<Char>()
        for (char in s) {
            if (char.isLetterOrDigit()) {
                chars.add(char)
            }
        }

        if(chars.isEmpty() || chars.size == 1) return true

        var left = 0
        var right = chars.size - 1
        do {
            if(chars[left] != chars[right]) return false
            left++
            right--
        } while (left < right)

        return true
    }
}

class Solution {
    fun isPalindrome(s: String): Boolean {
        fun checkPalindrome(left: Int, right: Int): Boolean {
            if(left >= right) return true

            if(!s[left].isLetterOrDigit()) {
                return checkPalindrome(left + 1, right)
            }

            if(!s[right].isLetterOrDigit()) {
                return checkPalindrome(left, right - 1)
            }


            if(!s[left].equals(s[right], ignoreCase = true)) return false

            return checkPalindrome(left + 1, right - 1)
        }

        return checkPalindrome(0, s.lastIndex)
    }
}
