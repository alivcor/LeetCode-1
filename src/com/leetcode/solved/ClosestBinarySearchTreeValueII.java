package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.solved.BalancedBinaryTree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        inorderFront(root, target, s1);
        inorderRev(root, target, s2);
        
        while(k-- > 0){
            if(s1.isEmpty()) result.add(s2.pop());
            else if(s2.isEmpty()) result.add(s1.pop());
            else if(Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target)) result.add(s1.pop());
            else result.add(s2.pop());
        }
        
        return result;
    }
    
    private void inorderFront(TreeNode root, double target, Stack<Integer> stack){
        if(root == null) return;
        inorderFront(root.left, target,stack);
        if(root.val > target) return;
        stack.add(root.val);
        inorderFront(root.right, target,stack);
    }
    private void inorderRev(TreeNode root, double target, Stack<Integer> stack){
        if(root == null) return;
        inorderRev(root.right, target,stack);
        if(root.val <= target) return;
        stack.add(root.val);
        inorderRev(root.left, target,stack);
    }
}
