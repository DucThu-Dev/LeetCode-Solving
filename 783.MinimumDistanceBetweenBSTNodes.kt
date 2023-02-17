import java.util.LinkedList

fun minDiffInBST(root: TreeNode?): Int {
    return checkEachNodeWithSequenceValues(root, arrayOf())
}

fun checkEachNodeWithSequenceValues(node: TreeNode?, numChecks: Array<Int>): Int {
    if (node == null || (node.left == null && node.right == null)) return Int.MAX_VALUE

    var minDiffLeft = Int.MAX_VALUE
    var minDiffRight = Int.MAX_VALUE
    val numChecksAndNodeValue = arrayOf(*numChecks, node.`val`)
    if (node.left != null) {
        for (n in numChecksAndNodeValue) {
            val diff = Math.abs(node.left!!.`val` - n)
            minDiffLeft = if (diff < minDiffLeft) diff else minDiffLeft
        }
        minDiffLeft = Math.min(minDiffLeft, checkEachNodeWithSequenceValues(node.left, numChecksAndNodeValue))
    }

    if (node.right != null) {

        for (n in numChecksAndNodeValue) {
            val diff = Math.abs(n - node.right!!.`val`)
            minDiffRight = if (diff < minDiffRight) diff else minDiffRight
        }
        minDiffRight = Math.min(minDiffRight, checkEachNodeWithSequenceValues(node.right, numChecksAndNodeValue))
    }

    return Math.min(minDiffLeft, minDiffRight)
}