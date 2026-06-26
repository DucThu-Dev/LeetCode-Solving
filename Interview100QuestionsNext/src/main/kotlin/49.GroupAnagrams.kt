package interview100questions

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if(strs.isEmpty()) return listOf()

        val map = hashMapOf<Int, MutableList<String>>()

        for(str in strs) {
            val key = representKey(str)
            if(map.contains(key)) {
                map[key]!!.add(str)
            } else {
                map[key] = mutableListOf(str)
            }
        }

        return map.values.toList()
    }

    private fun representKey(str: String): Int {
        val count = IntArray(26)
        for(char in str) {
            count[char.code - 97]++
        }
        return count.contentHashCode()
    }
}