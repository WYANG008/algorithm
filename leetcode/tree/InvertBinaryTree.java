package tree;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree testRunner = new InvertBinaryTree();

        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node7;

        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;
        testRunner.invertTree(root);
    }


}
