package lianxi20220817;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        //单调栈是从后面开始扫描
        for (int i = nums2.length - 1; i >= 0; i--) {
            //如果栈是空的，直接入栈，如果栈顶元素比i还小，那就直接出栈，
            //一直到栈为空 或者 栈顶元素比nums2[i]还大。
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            hm.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            //直接入栈
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = hm.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 1, 2};
        int[] b = new int[]{1, 3, 4, 2};
        System.out.println(new Solution().nextGreaterElement(a, b));
    }
}