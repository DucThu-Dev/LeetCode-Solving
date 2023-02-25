fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    invertTree(root.left)
    invertTree(root.right)
    root.left = root.right.also { root.right = root.left }

    return root
}