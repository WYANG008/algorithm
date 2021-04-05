package tree;

public class FlatternBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);

        root.left = null;

        if(left == null) return;
        root.right = left;

        TreeNode p = left;
        while(p.right!=null) {
            p = p.right;
        }

        p.right = right;


    }
}
