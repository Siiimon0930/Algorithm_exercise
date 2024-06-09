package LeetCodeHot100.dualPoint;

/**
 * @Description: 11.盛最多水的容器
 * @Author: Siiimon
 * @Date: 2024/06/09/17:03
 */
public class MaxArea {
    // 暴力法，遍历O(n2)，会超时
    public int maxArea0(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    // 双指针法，头尾一个指针，每次高度小的移动位置。
    public int maxArea(int[] height) {
        int maxArea = 0;
        if(height.length < 2)
            return 0;
        int left = 0;
        int right = height.length-1;
        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            if(area > maxArea){
                maxArea = area;
            }
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
