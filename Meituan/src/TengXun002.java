import java.util.*;


class TreeNode {
    int val = 0;
TreeNode left = null;
TreeNode right = null;
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 你需要返回一个指针，指向root，表示删减去若干个点后，剩下的树
     * @param root TreeNode类 指向二叉树的根
     * @return TreeNode类
     */
    public TreeNode solve (TreeNode root) {
        // write code here
        Queue<TreeNode> queue =new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Queue<TreeNode> tmp = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.offer(node);
                if (node.left ==null || node.right==null){
                    node.left = null;
                    node.right = null;
                    while (!tmp.isEmpty()){
                        TreeNode del = tmp.poll();
                        del.left= null;
                        del.right = null;
                    }
                    while (!queue.isEmpty()){
                        node = queue.poll();
                        node.left = null;
                        node.right = null;
                    }
                    return root;
                }else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}