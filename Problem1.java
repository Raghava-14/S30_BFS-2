//Time = O(n)
//Space = 

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
    public List<Integer> rightSideView(TreeNode root) {
        // Initialize an empty list to store the result
        List<Integer> result = new ArrayList<>();
        // If the root is null, return the empty list
        if (root == null) {
            return result;
        }
        // Initialize a queue to store the nodes in each level
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root node to the queue
        queue.add(root);
        // Loop until the queue is empty
        while (!queue.isEmpty()) {
            // Get the number of nodes in the current level
            int size = queue.size();
            // Loop over the nodes in the current level
            for (int i = 0; i < size; i++) {
                // Remove the first node from the queue
                TreeNode node = queue.poll();
                // If this is the last node in the current level, add its value to the result list
                if (i == size - 1) {
                    result.add(node.val);
                }
                // Add the left child of the current node to the queue (if it exists)
                if (node.left != null) {
                    queue.add(node.left);
                }
                // Add the right child of the current node to the queue (if it exists)
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // Return the result list containing the right side view of the tree
        return result;
    }
}
