package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LT503_Next_Greater_Element_2 {

    // 循环数组中比当前元素大的下一个元素
    // Input: nums = [1,2,1]
    // Output: [2,-1,2]

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);
            }
            stack.add(num);
        }
        int[] ret = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])) ret[i] = map.get(nums1[i]);
            else ret[i] = -1;
        }
        return ret;
    }

}
