
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] nodes = data.split(",");
        int[] idx = {0};

        return build(nodes, idx);
    }

    private TreeNode build(String[] nodes, int[] idx) {
        if (nodes[idx[0]].equals("#")) {
            idx[0]++;
            return null;
        }

        TreeNode root = new TreeNode(
            Integer.parseInt(nodes[idx[0]++])
        );

        root.left = build(nodes, idx);
        root.right = build(nodes, idx);

        return root;
    }
}
