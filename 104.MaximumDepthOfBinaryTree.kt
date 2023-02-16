fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val dataHolder = DataHolder(1)

    treeNodeTravel(root, 1, dataHolder)

    return dataHolder.max
}

fun treeNodeTravel(node: TreeNode, currentNodeLength: Int, dataHolder: DataHolder) {
    if (node.left != null) {
        treeNodeTravel(node.left!!, currentNodeLength + 1, dataHolder)
    }

    if (node.right != null) {
        treeNodeTravel(node.right!!, currentNodeLength + 1, dataHolder)
    }

    if (node.right == null && node.left == null) {
        if(currentNodeLength > dataHolder.max) {
            dataHolder.max = currentNodeLength
        }
    }
}

data class DataHolder(var max: Int)

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}