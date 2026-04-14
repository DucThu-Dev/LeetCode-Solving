package interview100questions

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val count = IntArray(27)
        for(i in s.indices) {
            count[s[i].code - 97]++
            count[t[i].code - 97]--
        }

        count.forEach { if(it != 0) return false }

        return true
    }
}