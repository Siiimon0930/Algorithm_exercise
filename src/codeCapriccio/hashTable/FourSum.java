package codeCapriccio.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* leetcode18. 四数之和:
*   给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
*   请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
*   （若两个四元组元素一一对应，则认为两个四元组重复）：
*       0 <= a, b, c, d < n
*       a、b、c 和 d 互不相同
*       nums[a] + nums[b] + nums[c] + nums[d] == target
*   你可以按 任意顺序 返回答案 。
* 解题思路：和三数之和思路一样的双指针，只不过多套一层for循环，注意剪枝时的判断条件要考虑全
*/
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int sum, left, right;
        // 0.数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > target && target >= 0)
                return result;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                left = j + 1;
                right = nums.length-1;
                if((nums[i] + nums[j] > target && target >= 0) || (nums[i] >= 0 && target < 0))
                    break;
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                while(left < right){
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target)
                        right--;
                    else if (sum < target) {
                        left++;
                    }else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1])
                            left++;
                        while(left < right && nums[right] == nums[right-1])
                            right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1000000000,1000000000,1000000000,1000000000};
        fourSum(a, -294967296);
    }
}
