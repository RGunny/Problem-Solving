package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/symmetric-tree/description/
 */
public class Q101_SymmetricTree {

    public static void main(String[] args) {
        // 기본 케이스
        assertTrue(isSymmetricRecursive(build(new Integer[]{1,2,2,3,4,4,3})), "대칭 트리 실패");
        assertTrue(isSymmetricIterative(build(new Integer[]{1,2,2,3,4,4,3})), "대칭 트리 실패");

        // 비대칭 케이스
        assertFalse(isSymmetricRecursive(build(new Integer[]{1,2,2,null,3,null,3})), "비대칭 트리 실패");
        assertFalse(isSymmetricIterative(build(new Integer[]{1,2,2,null,3,null,3})), "비대칭 트리 실패");

        // 빈 트리
        assertTrue(isSymmetricRecursive(build(new Integer[]{})), "빈 트리 실패");
        assertTrue(isSymmetricIterative(build(new Integer[]{})), "빈 트리 실패");

        // 단일 노드
        assertTrue(isSymmetricRecursive(build(new Integer[]{1})), "단일 노드 실패");
        assertTrue(isSymmetricIterative(build(new Integer[]{1})), "단일 노드 실패");
    }

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
    public static boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    /**
     *  [1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 6, 5]
     *           1
     *        2     2
     *      3  4   4  3
     *    5 6 7 8 8 7 6 5
     *
     */
    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;


            q.add(left.left);
            q.add(right.right);

            q.add(left.right);
            q.add(right.left);
        }

        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    private static TreeNode build(Integer[] values) {
        if (values == null || values.length == 0) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int index = 1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (index < values.length && values[index] != null) {
                node.left = new TreeNode(values[index]);
                q.add(node.left);
            }
            index++;
            if (index < values.length && values[index] != null) {
                node.right = new TreeNode(values[index]);
                q.add(node.right);
            }
            index++;
        }
        return root;
    }
}
