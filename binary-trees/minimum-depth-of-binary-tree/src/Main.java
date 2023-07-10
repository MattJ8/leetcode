public class Main {
    public static void main(String[] args) {

//        Given a binary tree, find its minimum depth.
//        The minimum depth is the number of nodes along the shortest path from
//        the root node down to the nearest leaf node.
//        Note: A leaf is a node with no children.

//        Input: root = [3,9,20,null,null,15,7]
//        Output: 2
//                               3
//                             /   \
//                            9     20
//                                /    \
//                               15     7

//        Input: root = [2,null,3,null,4,null,5,null,6]
//        Output: 5
//                                  2
//                                    \
//                                     3
//                                      \
//                                       4
//                                        \
//                                         5
//                                          \
//                                           6

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

    }

    public int minDepth(TreeNode root) {
        // when the root doesn't exist we have no depth so return 0
        if (root == null) return 0;
        // else depth must be at least 1
        int depth = 1;
        // created queue to move from the front of the tree to the back
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root); // like add to queue but will not cause error if queue is full
        while (!que.isEmpty()){ // while we haven't removed everything from our queue
            int size = que.size();
            // for each level in our tree
            for (int i = 0; i < size; i++){
                TreeNode node = que.poll(); // return front of queue
                // is the front of our queue a leaf?
                if (node.left == null && node.right == null){
                    // as soon as we encounter a leaf we exist
                    return depth;
                }
                // does the left node exist, if so step along it
                if (node.left != null){
                    que.offer(node.left);
                }
                // does the right node exist, if so step along it
                if (node.right != null){
                    que.offer(node.right);
                }
            }
            depth ++;
        }
        return depth;
    }

}