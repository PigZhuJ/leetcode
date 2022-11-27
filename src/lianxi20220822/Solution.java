package lianxi20220822;

import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getTheTreeHeight(root);
        int row = height + 1;
        int col = (int) Math.pow(2, height + 1) - 1;
        int[][] array = new int[row][col];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j]=10000;
            }
        }
        //BFS扫描
        array[0][(col - 1) / 2] = root.val;
        deepSearchTree(root, array, 0, (col - 1) / 2, height);
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            ArrayList<String> childList = new ArrayList<>();
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 10000) {
                    childList.add("");
                } else {
                    childList.add(String.valueOf(array[i][j]));
                }
            }
            list.add(childList);
        }
        return list;
    }

    private void deepSearchTree(TreeNode root, int[][] array, int row, int col, int height) {
        if (root.left != null) {
            int rowIndex = row + 1;
            int colIndex = (int) (col - Math.pow(2, height - row - 1));
            array[rowIndex][colIndex] = root.left.val;
            deepSearchTree(root.left, array, rowIndex, colIndex, height);
        }
        if (root.right != null) {
            int rowIndex = row + 1;
            int colIndex = (int) (col + Math.pow(2, height - row - 1));
            array[rowIndex][colIndex] = root.right.val;
            deepSearchTree(root.right, array, rowIndex, colIndex, height);
        }
    }

    private int getTheTreeHeight(TreeNode root) {
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                if (tn.right != null) {
                    queue.offer(tn.right);
                }
                if (tn.left != null) {
                    queue.offer(tn.left);
                }
            }
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(3);
        TreeNode tn2 = new TreeNode(4);
        TreeNode tn3 = new TreeNode(5);
        TreeNode tn4 = new TreeNode(6);
        tn1.right = tn2;
        tn2.right = tn3;
        tn3.right = tn4;
        System.out.println(new Solution().printTree(tn1));
    }
}