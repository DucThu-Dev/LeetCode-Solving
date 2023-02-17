fun minDiffInBST(root: TreeNode?): Int {
    if (root == null || (root.left == null && root.right == null)) return Int.MAX_VALUE
    var minDiff: Int = Int.MAX_VALUE
    if (root.left != null) minDiff = root.`val` - root.left!!.`val`
    if (root.right != null) {
        minDiff = Math.min(root.right!!.`val` - root.`val`, minDiff)

    }
    return Math.min(Math.min(minDiffInBST(root.left), minDiffInBST(root.right)), minDiff)
}