package corrected_assment;
class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}
public class BinaryTree {
    TreeNode root;


    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }


    public int findSecondLargest() {
        if (root == null || (root.left == null && root.right == null)) {
            throw new IllegalArgumentException("Tree must have at least two TreeNodes.");
        }
        return findSecondLargestRec(root);
    }

    private int findSecondLargestRec(TreeNode node) {
        TreeNode parent = null;
        TreeNode current = node;


        while (current.right != null) {
            parent = current;
            current = current.right;
        }


        if (current.left != null) {
            return findLargest(current.left);
        }


        return parent.value;
    }

    private int findLargest(TreeNode node) {
        TreeNode current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        
        for (int val : values) {
            tree.insert(val);
        }

        try {
            int secondLargestValue = tree.findSecondLargest();
            System.out.println("Second largest value: " + secondLargestValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
