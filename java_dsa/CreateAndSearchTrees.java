public class CreateAndSearchTrees {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data=data;
        }
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    TreeNode createBinaryNode(int data, TreeNode left, TreeNode right) {
        return new TreeNode(data,left,right);
    }
    public static void main(String[] args) {
        CreateAndSearchTrees bts = new CreateAndSearchTrees();
        TreeNode left = new CreateAndSearchTrees.TreeNode(2);
        TreeNode right = new CreateAndSearchTrees.TreeNode(3);
        TreeNode root = new CreateAndSearchTrees.TreeNode(1,left,right);
        left.left = new CreateAndSearchTrees.TreeNode(4);
        left.right = new CreateAndSearchTrees.TreeNode(5);
        right.left = new CreateAndSearchTrees.TreeNode(6);
        right.right = new CreateAndSearchTrees.TreeNode(7);
    }
}
