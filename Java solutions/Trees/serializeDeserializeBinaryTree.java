import java.util.*;
/**
 * Definition for a binary tree node.
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Codec {

    int i;
    List<String> elements;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        elements = new ArrayList<>();
        preOrderTraversal(root);

        return String.join(",",elements);

    }

    private void preOrderTraversal(TreeNode node)
    {
        if(node == null)
        {
            elements.add("N");
            return;
        }

        elements.add(String.valueOf(node.val));
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);

        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] res = data.split(",");
        i = 0;
        return dfs(res);
    }

    private TreeNode dfs(String[] arr)
    {
        if(arr[i].equals("N"))
        {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        node.left = dfs(arr);
        node.right = dfs(arr);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));