package leetcode.doublepointer;

//题目描述：把归并结果存到第一个数组上
public class LT88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1; // 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值
        int idx = m + n - 1;
        while(i >= 0 || j >= 0){
            if(i < 0)
                nums1[idx] = nums2[j--]; //数组1用完了
            else if(j < 0)
                nums1[idx] = nums1[i--];//数组2用完了
            else if(nums1[i] > nums2[j])
                nums1[idx] = nums1[i--];
            else
                nums1[idx] = nums2[j--];
            idx--;
        }
    }


}
