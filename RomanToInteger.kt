import java.lang.IllegalArgumentException

class RomanToInteger {
    companion object {
        val subtractionSymbols: List<String> = listOf("I", "X", "C");
    }

    fun romanToInt(s: String): Int {
        var result: Int = 0
        var remain: String = s
        var currentSymbols: String = ""

        while (remain.isNotEmpty()) {
            currentSymbols = remain.substring(0, 1);
            remain.drop(1);

            if(shouldPickNextChar(currentSymbols))
        }

        return result;
    }

    fun convertRomanToInt(char: String): Int {
        return when(char) {
            "I" -> 1
            "II" -> 2
            "III" -> 3
            "IV" -> 4
            "V" -> 5
            "X" -> 10
            "L" -> 50
            "C" -> 100
            "D" -> 500
            "M" -> 1000
            else -> throw IllegalArgumentException("Invalid Roman symbol!")
        }
    }

    private fun shouldPickNextChar(char: String): Boolean {
        return subtractionSymbols.contains(char)
    }
}
