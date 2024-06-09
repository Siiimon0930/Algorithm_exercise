package LeetCodeHot100.dualPoint;

/**
 * @Description: 283.移动零
 * @Author: Siiimon
 * @Date: 2024/06/09/16:52
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int count = 0;
        // 非零元素往前移动count个位置
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                count++;
            }else {
                nums[i-count] = nums[i];
            }
        }
        // 数组后count个元素填充0
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
