fun main() {
    val tree = AVLTree().apply {
        insert(1)
        insert(100)
        insert(23)
        insert(54)
        insert(234)
        insert(4)
        insert(43)
        insert(8)
    }

    println(tree)
}

class AVLTree {
    var root: AVLNode? = null;

    fun insert(value: Int) {
        root = insert(root, value)
    }

    fun insert(node: AVLNode?, value: Int): AVLNode {
        node ?: return AVLNode(value)
        if (node.value.compareTo(value) > 0) {
            node.left = insert(node.left, value)
        } else {
            node.right = insert(node.right, value)
        }

        val balanceNode = balance(node)
        balanceNode.height = Math.max(balanceNode.leftHeight, balanceNode.rightHeight) + 1

        return balanceNode
    }

    fun balance(node: AVLNode): AVLNode {
        return when (node.balanceFactor) {

            2 -> {
                if (node.left!!.balanceFactor == -1) {
                    leftRightRotate(node)
                } else {
                    rightRotate(node)
                }
            }

            -2 -> {
                if (node.right!!.balanceFactor == 1) {
                    rightLeftRotate(node)
                } else {
                    leftRotate(node)
                }
            }

            else -> node
        }
    }

    fun leftRotate(node: AVLNode): AVLNode {
        val pivot = node.right!!
        pivot.left = node
        node.right = null

        node.height = Math.max(node.leftHeight, node.rightHeight) + 1
        pivot.height = Math.max(pivot.leftHeight, pivot.rightHeight) + 1

        return pivot
    }

    fun rightRotate(node: AVLNode): AVLNode {
        val pivot = node.left!!
        pivot.right = node
        node.left = null

        node.height = Math.max(node.leftHeight, node.rightHeight) + 1
        pivot.height = Math.max(pivot.leftHeight, pivot.rightHeight) + 1

        return pivot
    }

    fun leftRightRotate(node: AVLNode): AVLNode {
        val leftNode = node.left ?: return node
        node.left = leftRotate(leftNode)
        return rightRotate(node)
    }

    fun rightLeftRotate(node: AVLNode): AVLNode {
        val rightNode = node.right ?: return node
        node.right = rightRotate(rightNode)
        return leftRotate(node)
    }

    override fun toString(): String {
        return root.toString()
    }
}

class AVLNode(var value: Int) {
    var left: AVLNode? = null
    var right: AVLNode? = null
    var height: Int = 0

    val leftHeight: Int
        get() = left?.height ?: -1

    val rightHeight: Int
        get() = right?.height ?: -1

    val balanceFactor: Int
        get() = leftHeight - rightHeight

    override fun toString() = diagram(this)

    private fun diagram(
        node: AVLNode?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.left == null && node.right == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.right, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(
                    node.left,
                    "$bottom│ ", "$bottom└──", "$bottom "
                )
            }
        } ?: "${root}null\n"
    }
}