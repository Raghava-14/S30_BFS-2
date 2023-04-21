//Time = O(n)
//Space = O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // If the root node is null, return false as there are no nodes to search.
        if (root == null) {
            return false;
        }
        // Create a queue to hold the nodes to be processed.
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root node to the queue.
        queue.offer(root);
        // Traverse the tree level by level using BFS.
        while (!queue.isEmpty()) {
            // Get the number of nodes in the current level.
            int size = queue.size();
            // Variables to keep track of whether x and y are found in the current level.
            boolean foundX = false;
            boolean foundY = false;
            // Process each node in the current level.
            for (int i = 0; i < size; i++) {
                // Get the next node in the queue.
                TreeNode node = queue.poll();
                // Check if the node has both left and right children.
                if (node.left != null && node.right != null) {
                    // Check if x and y are children of the same parent.
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                        return false; // If they are, they are not cousins.
                    }
                }
                // Check if the current node is x or y.
                if (node.val == x) {
                    foundX = true;
                }
                if (node.val == y) {
                    foundY = true;
                }
                // Add the left and right children of the current node to the queue.
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // Check if both x and y were found in the current level.
            if (foundX && foundY) {
                return true; // If they were, they are cousins.
            }
        }
        // If x and y were not found in the tree, return false.
        return false;
    }
}
