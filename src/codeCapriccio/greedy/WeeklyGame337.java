package codeCapriccio.greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class WeeklyGame337 {
    // 1. 6319. 奇偶位数
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        boolean oddFlag = false;
        while(n > 0){
            int temp = n % 2;
            n = n / 2;
            if(temp == 1){
                if(oddFlag)
                    res[1] += 1;
                else
                    res[0] += 1;
            }
            oddFlag = !oddFlag;
        }
        return res;
    }

    // 2. 6322. 检查骑士巡视方案
    private boolean[][] used; 
    public boolean checkValidGrid(int[][] grid) {
        used = new boolean[grid.length][grid.length];
        used[0][0] = true;
        return isValid(grid, used, 0, 0);
    }
    
    private boolean isValid(int[][] grid, boolean[][] used, int row, int col){
        int tempRow, tempCol;
        // 右上1
        tempRow = row - 2;
        tempCol = col + 1;
        if(tempRow >= 0 && tempCol < grid.length && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 右上2
        tempRow = row - 1;
        tempCol = col + 2;
        if(tempRow >= 0 && tempCol < grid.length && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 右下1
        tempRow = row + 1;
        tempCol = col + 2;
        if(tempRow < grid.length && tempCol < grid.length && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 右下2
        tempRow = row + 2;
        tempCol = col + 1;
        if(tempRow < grid.length && tempCol < grid.length && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 左上1
        tempRow = row - 2;
        tempCol = col - 1;
        if(tempRow >= 0 && tempCol >= 0 && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 左上2
        tempRow = row - 1;
        tempCol = col - 2;
        if(tempRow >= 0 && tempCol >= 0 && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 左下1
        tempRow = row + 1;
        tempCol = col - 2;
        if(tempRow < grid.length && tempCol >= 0 && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }
        // 左下2
        tempRow = row + 2;
        tempCol = col - 1;
        if(tempRow < grid.length && tempCol >= 0 && grid[tempRow][tempCol] == grid[row][col] + 1 && used[tempRow][tempCol] == false){
            used[tempRow][tempCol] = true;
            return isValid(grid, used, tempRow, tempCol);
        }

        return isFull(used);
    }

    private boolean isFull(boolean[][] used){
        for (int i = 0; i < used.length; i++) {
            for (int j = 0; j < used.length; j++) {
                if(used[i][j] == false)
                    return false;
            }
        }
        return true;
    }


    // 3. 6352. 美丽子集的数目
    private int res = 0;
    private LinkedList<Integer> subSet = new LinkedList<>();
    public int beautifulSubsets(int[] nums, int k) {
        backTracking(nums, k, 0);
        return res;
    }

    private void backTracking(int[] nums, int k, int startIndex){
        if(startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(isValid(subSet, k, nums[i])){
                subSet.add(nums[i]);
                res++;
                backTracking(nums, k, i+1);
                subSet.removeLast();
            }
        }
    }
    
    private boolean isValid(LinkedList<Integer> subSet, int k, int newValue){
        for (int i = 0; i < subSet.size(); i++) {
            if(newValue - subSet.get(i) == k || subSet.get(i) - newValue == k)
                return false;
        }
        return true;
    }

    // 4. 6321. 执行操作后的最大 MEX （没做出来！栈溢出）
    public int findSmallestInteger(int[] nums, int value) {
        Arrays.sort(nums);
        int MEX = findCurrentMEX(nums);
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] - MEX) % value == 0){
                nums[i] = MEX;
                return findSmallestInteger(nums, value);
            }
        }
        return MEX;
    }

    private int findCurrentMEX(int[] nums){
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0){
                continue;
            }else if(nums[i] == 0)
                flag = true;
            else {
                if(flag == false)
                    return 0;
                if(nums[i] != nums[i-1] + 1)
                    return nums[i-1] + 1;
            }
        }
        return nums[nums.length-1] >= 0 ? nums[nums.length-1]+1 : 0;
    }
}
