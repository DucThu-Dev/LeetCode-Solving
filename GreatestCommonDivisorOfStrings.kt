import java.util.*

class GreatestCommonDivisorOfStrings {
    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1 == str2) return str1
        if (str1 == "" || str2 == "") return ""

        val str1Length = str1.length
        val str2Length = str2.length

        val gcds = getGCD(str1Length, str2Length)

        out@ while (gcds.isNotEmpty()) {
            val currentLength = gcds.pop()
            val currentTestValue = str1.substring(0, currentLength)
            for (i in 0 until str1Length - currentLength + 1 step currentLength) {
                if (str1.substring(i, i + currentLength) != currentTestValue) {
                    continue@out
                }
            }

            for (i in 0 until str2Length - currentLength + 1 step currentLength) {
                if (str2.substring(i, i + currentLength) != currentTestValue) {
                    continue@out
                }
            }

            return currentTestValue
        }
        return ""
    }

    private fun getGCD(num1: Int, num2: Int): Stack<Int> {
        val results = Stack<Int>()
        val smaller = if (num1 < num2) num1 else num2
        var currentNum = 1;
        while (currentNum <= smaller) {
            if (num1 % currentNum == 0 && num2 % currentNum == 0) {
                results.push(currentNum);
            }
            currentNum++
        }

        return results
    }
}