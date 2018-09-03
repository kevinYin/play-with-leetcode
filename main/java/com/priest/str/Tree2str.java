package com.priest.str;


public class Tree2str {

    public String tree2str(TreeNode t) {

        if (t == null) {
            return "";
        }

        return buildNodeStr(t);
    }

    private  String buildNodeStr(TreeNode treeNode) {
        String nodeStr = treeNode.val + "";

        if (treeNode.left == null && treeNode.right == null) {
            return treeNode.val + "";
        }

        if (treeNode.left != null) {
           nodeStr =  nodeStr + "(" + buildNodeStr(treeNode.left) + ")";
        } else {
            nodeStr = nodeStr + "()";
        }

        if (treeNode.right != null) {
           nodeStr =  nodeStr + "(" + buildNodeStr(treeNode.right) + ")";
        }

        if (nodeStr.endsWith("()")) {
            nodeStr.substring(0, nodeStr.length() - "()".length());
        }
        return nodeStr;

    }

    public static void main(String[] args) {
        Tree2str tree2str = new Tree2str();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}