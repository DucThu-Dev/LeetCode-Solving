/**
 * [Problem original source]('https://leetcode.com/problems/palindrome-number/')
 */

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if(x < 0) return false;
        if(x == 0) return true;
        val original = x.toString()
        val revertedOrg = original.reversed()
        if (original == revertedOrg) return true;
        return false;
    }
}